package com.ziiwee.support.wechat;

import com.ziiwee.support.wechat.aes.AesException;
import org.json.JSONObject;
import org.json.XML;

/**
 * Created by ziiwee on 2016/12/2.
 * 微信开放平台服务接入
 */
public class WeOpenServer {

    private WeComponent weComponent;

    private String componentAppId;
    private String componentAppSecret;
    private String componentToken;
    private String componentEncodingAesKey;

    private WeReceiveDispatch weReceiveDispatch;

    public WeOpenServer(WeReceiveDispatch weReceiveDispatch, String componentAppId, String componentAppSecret, String
            componentToken, String componentEncodingAesKey) {
        this.weReceiveDispatch = weReceiveDispatch;
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
                if (weComponent == null) {
                    weComponent = new WeComponent(componentAppId, componentAppSecret, verifyTicket);
                } else {
                    weComponent.setVerifyTicket(verifyTicket);
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

    public String message(String requestBody, String appId, String signature, String
            timestamp, String nonce, String openid, String encrypt_type, String msg_signature) {
        String content = null;
        try {
            content = WeComponent.decrypt(requestBody, componentAppId, componentToken, componentEncodingAesKey);
            String result = weReceiveDispatch.dispatch(content);
            content = WeComponent.encrypt(result, componentAppId, componentToken, componentEncodingAesKey, timestamp, nonce);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return content;
    }

    public WeComponent getWeComponent() {
        return this.weComponent;
    }

}
