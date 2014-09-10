package com.tongtu.controller.status;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/7/16 0016 10:30
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Controller
@RequestMapping("/server")
public class ServerStatusContorller {
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ResponseBody
    public Boolean serverStatus() {
        return Boolean.TRUE;
    }
}
