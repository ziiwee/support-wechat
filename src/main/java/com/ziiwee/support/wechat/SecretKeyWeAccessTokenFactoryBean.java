package com.ziiwee.support.wechat;

import com.ziiwee.support.wechat.util.HttpRequestUtil;
import org.json.JSONObject;

import java.util.Collections;
import java.util.Map;

/**
 * Created by ziiwee on 2016/11/28.
 * 通过appId和appSecret创建的AccessToken
 */
public class SecretKeyWeAccessTokenFactoryBean implements WeAccessTokenFactory {

    /**
     * TODO
     */

    private static Map<String, SecretKeyWeAccessToken> tokenMap = Collections.emptyMap();


    public SecretKeyWeAccessTokenFactoryBean(String appId, String appSecret) {
        createAccessToken(appId, appSecret);
    }

    public void createAccessToken(String appId, String appSecret) {
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
            url += "&appid=" + appId;
            url += "&secret=" + appSecret;
            JSONObject jo = new JSONObject(HttpRequestUtil.get(url));
            SecretKeyWeAccessToken token = new SecretKeyWeAccessToken();
            token.setAppId(appId);
            token.setAppSecret(appSecret);
            token.setAccessToken(jo.get("access_token").toString());
            token.setExpirationTime(Long.parseLong(jo.get("access_token").toString()));
            tokenMap.put("appId", token);
        } catch (Exception e) {
            throw new WeChatException("获取AccessToken失败");
        }
    }

    @Override
    public WeAccessToken getCurrentAccessToken(String appId) {
        return null;
    }

    @Override
    public WeAccessToken refreshAccessToken(String appId) {
        return null;
    }
}
