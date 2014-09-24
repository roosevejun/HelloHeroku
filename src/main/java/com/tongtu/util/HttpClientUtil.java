package com.tongtu.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/9/24 0024 14:09
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Named("httpClientUtil")
public class HttpClientUtil {
    @Inject
    private CloseableHttpClient httpClient;
    private List<NameValuePair> qparams = null;
    private Charset charset;
    private String btnValue;
    private String postUrl;
    private static Map<String, String> params = null;
    private static Logger businessLogger = LogManager.getLogger("info");

    public HttpClientUtil() {
        charset = StandardCharsets.UTF_8;
    }

    public void HttpClientUtilParamsInit(List<NameValuePair> qparams, Charset charset, String btnValue, String postUrl) {
        this.qparams = qparams;
        this.charset = charset;
        this.btnValue = btnValue;
        this.postUrl = postUrl;
    }

    @PostConstruct
    private void init() {
        businessLogger.info("HttpClientUtil init");
    }

    @PreDestroy
    private void destroy() {
        businessLogger.info("HttpClientUtil destroy");
        try {
            httpClient.close();
        } catch (IOException e) {
            businessLogger.error(e.getMessage());
        }
    }

    public String getHtmlContent() {
        StringBuffer sb = new StringBuffer();
        HttpGet post = new HttpGet(postUrl);
//        post.setEntity(new UrlEncodedFormEntity(qparams, charset));
        HttpResponse response = null;
        try {
            response = httpClient.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            businessLogger.info("statusCode:{}", statusCode);
            HttpEntity entity = response.getEntity();
            String  content = getHTMLContent(entity.getContent());
            businessLogger.info("content: {}" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String postHtmlContent() {
        StringBuffer sb = new StringBuffer();
        HttpPost post = new HttpPost(postUrl);
        post.setEntity(new UrlEncodedFormEntity(qparams, charset));
        HttpResponse response = null;
        try {
            response = httpClient.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            businessLogger.info("statusCode:{}", statusCode);
            HttpEntity entity = response.getEntity();
            String  content = getHTMLContent(entity.getContent());
            businessLogger.info("content: {}" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String getHTMLContent(InputStream in) {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        try {
            String line = null;
            while((line=br.readLine())!=null){
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
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

