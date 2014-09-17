package com.tongtu.controller.zyzg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/9/17 0017 9:09
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Controller
@RequestMapping("/publics/examSupeCharge")
public class QueryVExamSupeCharge {
    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView queryexamSupeCharge() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("publics/examSupeCharge/queryVExamSupeCharge");
        return mav;
    }
}
