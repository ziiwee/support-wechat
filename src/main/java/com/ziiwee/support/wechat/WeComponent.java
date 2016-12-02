package com.ziiwee.support.wechat;

import com.ziiwee.support.wechat.aes.AesException;
import com.ziiwee.support.wechat.aes.WXBizMsgCrypt;
import com.ziiwee.support.wechat.util.HttpRequestUtil;
import org.json.JSONObject;
import org.json.XML;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Created by ziiwee on 2016/12/2.
 */
public class WeComponent {

    private String verifyTicket;

    private String appId;

    private String appSecret;

    private String accessToken;

    private long accessTokenExpires;

    public WeComponent(String appId, String appSecret, String verifyTicket) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.verifyTicket = verifyTicket;
    }

    /**
     * 创建AccessToken
     */
    private void createAccessToken() {
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
            JSONObject params = new JSONObject();
            params.put("component_appid", this.appId);
            params.put("component_appsecret", this.appSecret);
            params.put("component_verify_ticket", this.verifyTicket);
            JSONObject result = new JSONObject(HttpRequestUtil.post(url, params.toString()));
            this.accessToken = result.get("component_access_token").toString();
            this.accessTokenExpires = new Date().getTime() + (7200 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取AccessToken,无效则重新获取
     *
     * @return
     */
    public String getAccessToken() {
        if (this.accessToken == null || this.isExpiredAccessToken()) {
            createAccessToken();
        }
        return this.accessToken;
    }

    /**
     * 判断AccessToken是否过期
     *
     * @return
     */
    public boolean isExpiredAccessToken() {
        return new Date().after(new Date(this.accessTokenExpires - 200));
    }

    public void setVerifyTicket(String verifyTicket) {
        this.verifyTicket = verifyTicket;
    }

    /**
     * 获取预授权码
     *
     * @return
     */
    public String getPreAuthCode() {
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=";
        url += getAccessToken();
        JSONObject result = new JSONObject(HttpRequestUtil.post(url, new JSONObject().put("component_appid", this
                .appId).toString()));
        return result.get("pre_auth_code").toString();
    }

    /**
     * 获取授权重定向url
     *
     * @param redirectURL
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getAuthURL(String redirectURL) throws UnsupportedEncodingException {
        String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage";
        url += "?component_appid=" + this.appId;
        url += "&pre_auth_code=" + getPreAuthCode();
        url += "&redirect_uri=" + URLEncoder.encode(redirectURL, "UTF-8");
        return url;
    }

    /**
     * 使用授权码获取授权详情
     *
     * @return
     */
    public String getAuthInfoByAuthCode(String authCode) {

        String url = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=";
        url += getAccessToken();
        JSONObject params = new JSONObject();
        params.put("component_appid", this.appId);
        params.put("authorization_code", authCode);
        return HttpRequestUtil.post(url, params.toString());
    }


    /**
     * 解密
     *
     * @return
     */
    public static String decrypt(String xml, String componentAppId, String componentToken, String
            componentEncodingAesKey) throws AesException {
        WXBizMsgCrypt crypt = new WXBizMsgCrypt(componentToken, componentEncodingAesKey, componentAppId);
        return crypt.decrypt(XML.toJSONObject(xml).getJSONObject("xml").get("Encrypt").toString());
    }

    /**
     * 加密
     *
     * @param xml
     * @param componentAppId
     * @param componentToken
     * @param componentEncodingAesKey
     * @param timeStamp
     * @param nonce
     * @return
     * @throws AesException
     */
    public static String encrypt(String xml, String componentAppId, String componentToken, String
            componentEncodingAesKey, String timeStamp, String nonce) throws AesException {
        WXBizMsgCrypt crypt = new WXBizMsgCrypt(componentToken, componentEncodingAesKey, componentAppId);
        return crypt.encryptMsg(xml, timeStamp, nonce);
    }

}
