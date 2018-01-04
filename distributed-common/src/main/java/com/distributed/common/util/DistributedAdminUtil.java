package com.distributed.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;
import sun.rmi.runtime.Log;

import javax.servlet.ServletContext;

/**
 * @Author: 周润斌
 * @Date: create in 上午 16:52 2018/1/3 0003
 * @Description:
 */
public class DistributedAdminUtil implements InitializingBean, ServletContextAware{

    private static final Logger LOGGER = LoggerFactory.getLogger(DistributedAdminUtil.class);


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        LOGGER.info("====== 开始解压distributed-Admin ======");
        String version = PropertiesFileUtil.getInstance("distributed-admin-client").get("distributed.admin.version");
        LOGGER.info("====== distributed.jar 版本: {}",version);
        String jarPth = servletContext.getRealPath("/WEB-INF/lib/distributed-admin-"+ version + ".jar");
        LOGGER.info("====== distributed.jar 包路径:{}",jarPth);
        String resources = servletContext.getRealPath("/")+"/resources/distributed-admin";
        LOGGER.info("====== distributed.jar 解压路径:{}",resources);
        JarUtil.decompress(jarPth,resources);
    }
}
