package com.tongtu.util;

import org.springframework.web.servlet.View;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/9/22 0022 15:21
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class PlainHtmlView implements View {
    private final String htmlDocument;

    public PlainHtmlView(String htmlDocument) throws IOException {
        this.htmlDocument = htmlDocument;
    }

    @Override
    public String getContentType() {
        return org.springframework.http.MediaType.TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletOutputStream out = response.getOutputStream();
        out.write(this.htmlDocument.getBytes("utf-8"));
    }
}
