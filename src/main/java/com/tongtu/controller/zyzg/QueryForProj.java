package com.tongtu.controller.zyzg;

import com.tongtu.util.MobileInformationPconline;
import com.tongtu.util.PlainHtmlView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/9/22 0022 17:13
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Controller
@RequestMapping("/zyzg/proj")
public class QueryForProj {
    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView queryexamSupeCharge() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("publics/SearchForProj/queryForProj");
        return mav;
    }

    @RequestMapping(value = "queryRes", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ModelAndView queryexamSupeChargeRes(@RequestParam("name") String name, @RequestParam("idCard") String idCard, @RequestParam("examId") String examId) {
        String url = "http://zjz.mot.gov.cn/rwqss/public/queryVExamSupeChargeList.shtml";
        MobileInformationPconline mobileInformationRegex = new MobileInformationPconline();
        Map<String, String> parameter = new HashMap<String, String>();
        parameter.put("name", name);
        parameter.put("idCard", idCard);
        parameter.put("examId", examId);
        String html = null;
        try {
            html = mobileInformationRegex.getHtmlContent(url, parameter, "utf-8");
            Document doc = Jsoup.parse(html);
            Elements elements = doc.select("table #table1");
            elements.addClass("table");
            Document newdoc = Jsoup.parseBodyFragment(elements.outerHtml());
            System.out.println(newdoc.html());
            return new ModelAndView(new PlainHtmlView(newdoc.html()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
