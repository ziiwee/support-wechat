package com.ziiwee.support.wechat;

import com.ziiwee.support.wechat.aes.AesException;
import org.json.JSONObject;
import org.json.XML;

/**
 * Created by ziiwee on 2016/12/2.
 * 微信开放平台服务接入
 */
public class WeOpenServer {

    public static WeComponent WE_COMPONENT = null;

    private String componentAppId;
    private String componentAppSecret;
    private String componentToken;
    private String componentEncodingAesKey;

    public WeOpenServer(String componentAppId, String componentAppSecret, String componentToken, String componentEncodingAesKey) {
        this.componentAppId = componentAppId;
        this.componentAppSecret = componentAppSecret;
        this.componentToken = componentToken;
        this.componentEncodingAesKey = componentEncodingAesKey;
    }

    public String event(String requestBody, String signature, String timestamp, String nonce, String encrypt_type, String msg_signature) {
        try {
            String content = WeComponent.decrypt(requestBody, componentAppId, componentToken, componentEncodingAesKey);
            JSONObject xml = XML.toJSONObject(content).getJSONObject("xml");

            String infoType = xml.get("InfoType").toString();
            if (infoType.equals("component_verify_ticket")) {
                //推送component_verify_ticket
                String verifyTicket = xml.get("ComponentVerifyTicket").toString();
                if (WE_COMPONENT == null) {
                    WE_COMPONENT = new WeComponent(componentAppId, componentAppSecret, verifyTicket);
                } else {
                    WE_COMPONENT.setVerifyTicket(verifyTicket);
                }
            } else {
                /*
                 *  TODO
                 *  "unauthorized"://取消授权通知
                 *  "authorized"://授权成功通知
                 *  "updateauthorized"://授权更新通知
                 */
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String message(WeReceiveDispatch weReceiveDispatch, String body, String appId, String signature, String
            timestamp, String nonce, String openid, String encrypt_type, String msg_signature) {
        String content = null;
        try {
            content = WeComponent.decrypt(body, componentAppId, componentToken, componentEncodingAesKey);
            String result = weReceiveDispatch.dispatch(content);
            content = WeComponent.encrypt(result, componentAppId, componentToken, componentEncodingAesKey, timestamp, nonce);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return content;
    }


}
