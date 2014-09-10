package com.tongtu.controller;

import com.tongtu.bean.App;
import com.tongtu.repository.AppRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/7/1 0001 17:00
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Controller
@RequestMapping("/app")
public class AppController {
    @Inject
    private AppRepository appRepository;
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    @ResponseBody
    public App updateTerminal(@PathVariable("id") String id) {
        return  appRepository.getOne(id);
    }
}
