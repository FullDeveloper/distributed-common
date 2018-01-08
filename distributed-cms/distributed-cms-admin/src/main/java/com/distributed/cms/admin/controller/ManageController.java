package com.distributed.cms.admin.controller;

import com.distributed.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:17 2018/1/5 0005
 * @Description:
 */
@Controller
@RequestMapping("/manage")
@Api(value = "后台控制器", description = "后台管理")
public class ManageController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ManageController.class);

    /**
     * 后台首页
     * @return
     */
    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/index.jsp";
    }

}
