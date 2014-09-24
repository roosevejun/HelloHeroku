package com.tongtu.controller.zyzg;

import com.tongtu.base.controller.BaseController;
import com.tongtu.util.HttpClientForAspx;
import com.tongtu.util.PlainHtmlView;
import org.apache.http.NameValuePair;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
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

import javax.inject.Inject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/9/24 0024 18:04
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Controller
@RequestMapping("/khglui/gwdj")
public class QueryGWDJ extends BaseController {
    @Inject
    private CloseableHttpClient httpClient;

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView queryexamSupeCharge() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("publics/khglui/QueryForGWDJ");
        return mav;
    }

    @RequestMapping(value = "queryRes", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ModelAndView queryexamSupeChargeRes(@RequestParam("ctl00$ContentPlaceHolder2$txtXingMing") String XingMing, @RequestParam("ctl00$ContentPlaceHolder2$txtSFZ") String SFZ, @RequestParam("ctl00$ContentPlaceHolder2$txtXiangMuMC") String XiangMuMC, @RequestParam("ctl00$ContentPlaceHolder2$txtDanWei") String DanWei, @RequestParam("ctl00$ContentPlaceHolder2$ddlZhuGuanBuMen") String ZhuGuanBuMen, @RequestParam("ctl00$ContentPlaceHolder2$txtShangGangTime") String ShangGangTime) throws IOException {
        String postUrl = "http://219.143.235.78:8080/khglui/GWDJSeach.aspx";

        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("ctl00$ContentPlaceHolder2$txtXingMing", XingMing));
        qparams.add(new BasicNameValuePair("ctl00$ContentPlaceHolder2$txtSFZ", SFZ));
        qparams.add(new BasicNameValuePair("ctl00$ContentPlaceHolder2$txtXiangMuMC", XiangMuMC));
        qparams.add(new BasicNameValuePair("ctl00$ContentPlaceHolder2$txtDanWei", DanWei));
        qparams.add(new BasicNameValuePair("ctl00$ContentPlaceHolder2$ddlZhuGuanBuMen", ZhuGuanBuMen));
        qparams.add(new BasicNameValuePair("ctl00$ContentPlaceHolder2$txtShangGangTime", ShangGangTime));
        HttpClientForAspx httpClientForAspx = new HttpClientForAspx(StandardCharsets.UTF_8, qparams, postUrl);
        if (httpClientForAspx.loadGetPage(httpClient)) {
            if (httpClientForAspx.doPost(httpClient)) {
                businessLogger.info("操作成功！");
                Document doc = Jsoup.parse(httpClientForAspx.getContent());
                Elements elements = doc.select("#ctl00_ContentPlaceHolder2_gvGWDJ");
                elements.addClass("table");
                Document newdoc = Jsoup.parseBodyFragment(elements.outerHtml());
                businessLogger.info(newdoc.html());
                return new ModelAndView(new PlainHtmlView(newdoc.html()));
            } else {
                businessLogger.info("操作失败！");
            }
        }
//        httpClient.close();
        return null;
    }
}
