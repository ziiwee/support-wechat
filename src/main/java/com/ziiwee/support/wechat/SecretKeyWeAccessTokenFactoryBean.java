package com.ziiwee.support.wechat;

import com.ziiwee.support.wechat.util.Assert;
import com.ziiwee.support.wechat.util.HttpRequestUtil;
import org.json.JSONObject;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziiwee on 2016/11/28.
 * 通过appId和appSecret创建的AccessToken
 */
public class SecretKeyWeAccessTokenFactoryBean implements WeAccessTokenFactory {

    private static Map<String, SecretKeyWeAccessToken> tokenMap = new HashMap<>();


    public SecretKeyWeAccessTokenFactoryBean(String appId, String appSecret) {
        createAccessToken(appId, appSecret);
    }

    public SecretKeyWeAccessToken createAccessToken(String appId, String appSecret) {
        try {
            Assert.hasLength(appId, "appId不可为空");
            Assert.hasLength(appSecret, "appSecret不可为空");

            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
            url += "&appid=" + appId;
            url += "&secret=" + appSecret;
            JSONObject result = new JSONObject(HttpRequestUtil.get(url));
            try {
                SecretKeyWeAccessToken token = new SecretKeyWeAccessToken();
                token.setAppId(appId);
                token.setAppSecret(appSecret);
                token.setAccessToken(result.get("access_token").toString());
                token.setExpirationTime(new Date().getTime() + 7200 * 1000L);
                tokenMap.put(appId, token);
                return token;
            } catch (Exception e) {
                throw new WeChatException(result.get("errmsg").toString());
            }
        } catch (Exception e) {
            throw new WeChatException(e.getMessage() == null ? "获取AccessToken失败" : e.getMessage());
        }
    }

    @Override
    public SecretKeyWeAccessToken getCurrentAccessToken(String appId) {
        try {
            SecretKeyWeAccessToken token = tokenMap.get(appId);
            if (token == null) {
                token = refreshAccessToken(appId);
            } else if (isExpired(token)) {
                token = refreshAccessToken(token);
            }
            return token;
        } catch (Exception e) {
            throw new WeChatException(e.getMessage() == null ? "获取AccessToken失败" : e.getMessage());
        }
    }

    @Override
    public SecretKeyWeAccessToken refreshAccessToken(String appId) {
        return refreshAccessToken(tokenMap.get(appId));
    }

    public SecretKeyWeAccessToken refreshAccessToken(SecretKeyWeAccessToken token) {
        return createAccessToken(token.getAppId(), token.getAppSecret());
    }

    @Override
    public boolean isExpired(String appId) {
        return isExpired(tokenMap.get(appId));
    }

    public boolean isExpired(SecretKeyWeAccessToken token) {
        return new Date().after(new Date(token.getExpirationTime() - 200));
    }
}
