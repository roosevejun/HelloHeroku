package com.tongtu.controller.access;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.tongtu.base.controller.BaseController;
import com.tongtu.util.WebUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.usc.wechat.mp.sdk.factory.PushEnumFactory;
import org.usc.wechat.mp.sdk.util.XmlUtil;
import org.usc.wechat.mp.sdk.vo.Signature;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.push.Push;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/9/11 0011 9:32
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Controller
public class Accesscontorller extends BaseController {
    private static final String TOKEN = "1228419491";

    @RequestMapping(method = RequestMethod.GET, value = "/access")
    protected ModelAndView token(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Signature signature = new Signature();
            boolean hasRights = checkSignature(signature, request);

            if (hasRights) {
                businessLogger.info("signature-success:{}", signature);
                WebUtil.outputString(response, signature.getEchostr());
            } else {
                businessLogger.info("signature-not-match:{}", signature);
                WebUtil.outputString(response, signature.getToken());
            }
        } catch (Exception e) {
            businessLogger.error("signature-error", e);
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/access")
    protected ModelAndView post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Signature signature = new Signature();
            if (!checkSignature(signature, request)) {
                businessLogger.info("signature-not-match:{}", signature);
                return null;
            }

            String sessionid = request.getSession().getId();
            String message = WebUtil.getPostString(request.getInputStream());
            businessLogger.info("push-xml:{},{}", sessionid, message);

            String messageType = getMsgType(message);
            PushEnumFactory pushEnum = EnumUtils.getEnum(PushEnumFactory.class, StringUtils.upperCase(messageType));
            Validate.notNull(pushEnum, "don't-support-%s-type-message", messageType);

            Push push = pushEnum.convert(message);
            businessLogger.info("push-obj:{},{}", sessionid, push);

            Reply reply = pushEnum.parse(push);
            String replyXml = XmlUtil.marshal(reply);

            if (StringUtils.isNotEmpty(replyXml)) {
                businessLogger.info("reply-xml:{},{}", sessionid, replyXml);
                businessLogger.info("reply-obj:{},{}", sessionid, reply);
                WebUtil.outputString(response, replyXml);
            } else {
                businessLogger.info("no-reply:{},{}", sessionid, reply);
            }
        } catch (Exception e) {
            businessLogger.error("push-reply-error", e);
        }
        return null;
    }

    private boolean checkSignature(Signature signature, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.populate(signature, request.getParameterMap());
        signature.setToken(TOKEN);

        String sign = Hashing.sha1().hashString(buildSignatureText(signature), Charsets.UTF_8).toString();
        return sign.equalsIgnoreCase(signature.getSignature());
    }

    private String buildSignatureText(Signature signature) {
        List<String> list = new ArrayList<String>();
        list.add(Validate.notNull(signature.getToken(), "missing-token"));
        list.add(Validate.notNull(signature.getTimestamp(), "missing-timestamp"));
        list.add(Validate.notNull(signature.getNonce(), "missing-nonce"));
        Collections.sort(list);

        return StringUtils.join(list, "");
    }

    private String getMsgType(String message) {
        return StringUtils.substringBetween(message, "<MsgType><![CDATA[", "]]></MsgType>");
    }
}
