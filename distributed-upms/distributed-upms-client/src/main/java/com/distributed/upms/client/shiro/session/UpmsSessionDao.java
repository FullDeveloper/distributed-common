package com.distributed.upms.client.shiro.session;

import com.distributed.upms.common.constant.UpmsConstant;
import com.distributed.common.util.RedisUtil;
import com.distributed.upms.client.util.SerializableUtil;
import org.apache.commons.lang.ObjectUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author: 周润斌
 * @Date: create in 上午 17:20 2018/1/2 0002
 * @Description: 基于redis的sessionDao，缓存共享session
 */
public class UpmsSessionDao extends CachingSessionDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsSessionDao.class);
    // 会话key
    private final static String DISTRIBUTED_UPMS_SHIRO_SESSION_ID = "distributed-upms-shiro-session-id";
    // 全局会话key
    private final static String DISTRIBUTED_UPMS_SERVER_SESSION_ID = "distributed-upms-server-session-id";
    // 全局会话列表key
    private final static String DISTRIBUTED_UPMS_SERVER_SESSION_IDS = "distributed-upms-server-session-ids";
    // code key
    private final static String DISTRIBUTED_UPMS_SERVER_CODE = "distributed-upms-server-code";
    // 局部会话key
    private final static String DISTRIBUTED_UPMS_CLIENT_SESSION_ID = "distributed-upms-client-session-id";
    // 单点同一个code所有局部会话key
    private final static String DISTRIBUTED_UPMS_CLIENT_SESSION_IDS = "distributed-upms-client-session-ids";

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        RedisUtil.set(DISTRIBUTED_UPMS_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        LOGGER.debug("doCreate >>>>> sessionId={}", sessionId);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String session = RedisUtil.get(DISTRIBUTED_UPMS_SHIRO_SESSION_ID + "_" + sessionId);
        LOGGER.debug("doReadSession >>>>> sessionId={}", sessionId);
        return SerializableUtil.deserialize(session);
    }

    @Override
    protected void doUpdate(Session session) {
        // 如果会话过期/停止 没必要再更新了
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return;
        }
        // 更新session的最后一次访问时间
        UpmsSession upmsSession = (UpmsSession) session;
        UpmsSession cacheUpmsSession = (UpmsSession) doReadSession(session.getId());
        if (null != cacheUpmsSession) {
            upmsSession.setStatus(cacheUpmsSession.getStatus());
            upmsSession.setAttribute("FORCE_LOGOUT", cacheUpmsSession.getAttribute("FORCE_LOGOUT"));
        }
        RedisUtil.set(DISTRIBUTED_UPMS_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        // 更新DISTRIBUTED_UPMS_SERVER_SESSION_ID、DISTRIBUTED_UPMS_SERVER_CODE过期时间 TODO
        LOGGER.debug("doUpdate >>>>> sessionId={}", session.getId());
    }

    @Override
    protected void doDelete(Session session) {
        String sessionId = session.getId().toString();
        String upmsType = ObjectUtils.toString(session.getAttribute(UpmsConstant.UPMS_TYPE));
        if ("client".equals(upmsType)) {
            // 删除局部会话和同一code注册的局部会话
            String code = RedisUtil.get(DISTRIBUTED_UPMS_CLIENT_SESSION_ID + "_" + sessionId);
            Jedis jedis = RedisUtil.getJedis();
            jedis.del(DISTRIBUTED_UPMS_CLIENT_SESSION_ID + "_" + sessionId);
            jedis.srem(DISTRIBUTED_UPMS_CLIENT_SESSION_IDS + "_" + code, sessionId);
            jedis.close();
        }
        if ("server".equals(upmsType)) {
            // 当前全局会话code
            String code = RedisUtil.get(DISTRIBUTED_UPMS_SERVER_SESSION_ID + "_" + sessionId);
            // 清除全局会话
            RedisUtil.remove(DISTRIBUTED_UPMS_SERVER_SESSION_ID + "_" + sessionId);
            // 清除code校验值
            RedisUtil.remove(DISTRIBUTED_UPMS_SERVER_CODE + "_" + code);
            // 清除所有局部会话
            Jedis jedis = RedisUtil.getJedis();
            Set<String> clientSessionIds = jedis.smembers(DISTRIBUTED_UPMS_CLIENT_SESSION_IDS + "_" + code);
            for (String clientSessionId : clientSessionIds) {
                jedis.del(DISTRIBUTED_UPMS_CLIENT_SESSION_ID + "_" + clientSessionId);
                jedis.srem(DISTRIBUTED_UPMS_CLIENT_SESSION_IDS + "_" + code, clientSessionId);
            }
            LOGGER.debug("当前code={}，对应的注册系统个数：{}个", code, jedis.scard(DISTRIBUTED_UPMS_CLIENT_SESSION_IDS + "_" + code));
            jedis.close();
            // 维护会话id列表，提供会话分页管理
            RedisUtil.lrem(DISTRIBUTED_UPMS_SERVER_SESSION_IDS, 1, sessionId);
        }
        // 删除session
        RedisUtil.remove(DISTRIBUTED_UPMS_SHIRO_SESSION_ID + "_" + sessionId);
        LOGGER.debug("doUpdate >>>>> sessionId={}", sessionId);
    }

    /**
     * 更改在线状态
     *
     * @param sessionId
     * @param onlineStatus
     */
    public void updateStatus(Serializable sessionId, UpmsSession.OnlineStatus onlineStatus) {
        UpmsSession session = (UpmsSession) doReadSession(sessionId);
        if (null == session) {
            return;
        }
        session.setStatus(onlineStatus);
        RedisUtil.set(DISTRIBUTED_UPMS_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
    }



}
