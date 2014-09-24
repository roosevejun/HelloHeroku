package com.tongtu.util;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/9/24 0024 11:12
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class HttpClientForAspx {
    private List<NameValuePair> qparams = null;
    private static Map<String, String> params = null;
    private Charset charset;
    private String btnValue;
    private String postUrl;
    private String content;
    //.Net隐藏域
    private final static String PREVIOUSPAGE = "__PREVIOUSPAGE";
    private final static String EVENTVALIDATION = "__EVENTVALIDATION";
    private final static String VIEWSTATE = "__VIEWSTATE";
    private static Logger businessLogger = LogManager.getLogger("info");

    public HttpClientForAspx(Charset charset, List<NameValuePair> params, String postUrl, String btnValue) {
        this.charset = charset;
        this.qparams = params;
        this.postUrl = postUrl;
        this.btnValue = btnValue;
    }

    public String getContent() {
        return content;
    }

    /**
     * 加载页面-通过GET方式
     */
    public boolean loadGetPage(HttpClient client) throws IOException {
        HttpGet get = new HttpGet(this.postUrl);
        HttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        businessLogger.info("loadGetPage statusCode:{}", statusCode);
        HttpEntity entity = response.getEntity();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(entity.getContent()));
        String buffer = null;
        StringBuilder sb = new StringBuilder();
        while ((buffer = reader.readLine()) != null) {
            sb.append(buffer);
        }
        params = getAllInputNames(sb.toString());
        get.abort();
        return statusCode == 200;
    }

    /**
     * 根据按钮名称进行操作
     */
    public boolean doPost(HttpClient client)
            throws IOException {

        StringBuffer sb = new StringBuffer();
        String acceptEncoding = "";
        HttpPost post = new HttpPost(postUrl);
        qparams.add(
                new BasicNameValuePair(PREVIOUSPAGE, params.get(PREVIOUSPAGE)));
        qparams.add(
                new BasicNameValuePair(EVENTVALIDATION, params.get(EVENTVALIDATION)));
        qparams.add(
                new BasicNameValuePair(VIEWSTATE, params.get(VIEWSTATE)));
        //包含目标按钮则执行操作
//        if (getKeyByValue(btnValue) != null) {
            qparams.add(new BasicNameValuePair(getKeyByValue(btnValue), btnValue));
            post.setEntity(new UrlEncodedFormEntity(qparams, charset));
            HttpResponse response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            businessLogger.info("statusCode:{}", statusCode);
            if (statusCode != HttpStatus.SC_OK) {
                businessLogger.info("sb:{}", sb.toString());
            } else {
                HttpEntity entity = response.getEntity();
                content = getHTMLContent(entity.getContent());
//                businessLogger.info("content: {}" + content);
                return true;
            }
//        }
//        businessLogger.info("not find button :[{}]", btnValue);
        post.abort();
        return false;
    }

    private static String getHTMLContent(InputStream in) {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    private static String getInputProperty(String input, String property) {
        Matcher m = Pattern.compile(property + "[\\s]*=[\\s]*\"[^\"]*\"").matcher(input);
        if (m.find()) {
            String v = m.group();
            return v.substring(v.indexOf("\"") + 1, v.length() - 1);
        }
        return null;
    }

    private static Map<String, String> getAllInputNames(String body) {
        Map<String, String> parameters = new HashMap<String, String>();
        Matcher matcher = Pattern.compile("<input[^<]*>").matcher(body);
        while (matcher.find()) {
            String input = matcher.group();
            if (input.contains("name")) {
                parameters.put(getInputProperty(input, "name"),
                        getInputProperty(input, "value"));
            }
        }
        return parameters;
    }

    private static String getKeyByValue(String value) {
        for (String s : params.keySet()) {
            if (params.get(s) == null) {
                continue;
            }
            if (params.get(s).equals(value)) {
                return s;
            }
        }
        return null;
    }

}
