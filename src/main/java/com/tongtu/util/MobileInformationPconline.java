package com.tongtu.util;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/9/22 0022 12:12
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class MobileInformationPconline {
    /**
     * 用正则表达式来提取抓取下来的html中的信息
     *
     * @throws org.apache.commons.httpclient.HttpException
     * @throws java.io.IOException
     */
    public String getHtmlContent(String htmlurl, Map<String, String> parameter, String charset)
            throws IOException {
        StringBuffer sb = new StringBuffer();
        String acceptEncoding = "";
        /* 1.生成 HttpClinet 对象并设置参数 */
        HttpClient httpClient = new HttpClient();
        // 设置 Http 连接超时 5s
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(
                5000);
//        GetMethod method = new GetMethod(htmlurl);
        PostMethod method = new PostMethod(htmlurl);
        // 设置 get 请求超时 5s
        method.getParams().getDoubleParameter(HttpMethodParams.SO_TIMEOUT, 10000);
        // 设置请求重试处理
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        for (Map.Entry<String, String> entry : parameter.entrySet()) {
            method.addParameter(entry.getKey(), entry.getValue());
        }
        int statusCode;
        try {
            statusCode = httpClient.executeMethod(method);
            // 判断访问的状态码
            if (statusCode != HttpStatus.SC_OK) {
                return sb.toString();
            } else {
                if (method.getResponseHeader("Content-Encoding") != null)
                    acceptEncoding = method
                            .getResponseHeader("Content-Encoding").getValue();
                if (acceptEncoding.toLowerCase().indexOf("gzip") > -1) {
                    // 建立gzip解压工作流
                    InputStream is;
                    is = method.getResponseBodyAsStream();
                    GZIPInputStream gzin = new GZIPInputStream(is);
                    InputStreamReader isr = new InputStreamReader(gzin, charset); // 设置读取流的编码格式，自定义编码
                    BufferedReader br = new BufferedReader(isr);
                    String tempbf;
                    while ((tempbf = br.readLine()) != null) {
                        sb.append(tempbf);
                        sb.append("\r\n");
                    }
                    isr.close();
                    gzin.close();
                    //System.out.println(sb);
                } else {
                    InputStreamReader isr;
                    isr = new InputStreamReader(
                            method.getResponseBodyAsStream(), charset);
                    BufferedReader br = new BufferedReader(isr);
                    String tempbf;
                    while ((tempbf = br.readLine()) != null) {
                        sb.append(tempbf);
                        sb.append("\r\n");
                    }
                    isr.close();
                }
            }
        } catch (HttpException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        method.abort();
        method.releaseConnection();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String url = "http://zjz.mot.gov.cn/rwqss/public/queryVExamSupeChargeList.shtml";
        MobileInformationPconline mobileInformationRegex = new MobileInformationPconline();
        Map<String, String> parameter = new HashMap<String, String>();
        parameter.put("name", "倪少君");
        parameter.put("idCard", "bbbbbbbb");
        parameter.put("examId", "aaaaaa");
        String html = mobileInformationRegex.getHtmlContent(url, parameter, "utf-8");
        Document doc = Jsoup.parse(html);
        Elements elements= doc.select("#table1");
        System.out.println(elements.html());

    }
}
