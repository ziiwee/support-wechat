package com.ziiwee.support.wechat2;

import com.ziiwee.support.wechat2.util.HttpRequestUtil;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by ziiwee on 2016/11/28.
 */
public class SecretKeyWeAccessToken implements WeAccessToken {

    private String appId;

    private String appSecret;       //appSecret

    private String accessToken;     //令牌

    private long expirationTime;  //到期时间

    public SecretKeyWeAccessToken(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String createWeAccessToken() {
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
            url += "&appid=" + appId;
            url += "&secret=" + appSecret;
            JSONObject jo = new JSONObject(HttpRequestUtil.get(url));
            try {
                this.accessToken = jo.get("access_token").toString();
                this.expirationTime = Long.parseLong(jo.get("expires_in").toString());
                return this.accessToken;
            } catch (Exception e) {
                throw new WeChatException(e.getMessage() + "错误信息: " + jo.get("errmsg").toString());
            }
        } catch (Exception e) {
            throw new WeChatException("创建AccessToken失败: " + e.getMessage());
        }
    }

    public String refreshWeAccessToken() {
        return createWeAccessToken();
    }

    public boolean isExpiredWeAccessToken() {
        return new Date().after(new Date(this.expirationTime - 200));
    }

    @Override
    public String getValue() {
        this.accessToken = this.accessToken == null ? createWeAccessToken() : this.accessToken;
        this.accessToken = isExpiredWeAccessToken() ? refreshWeAccessToken() : this.accessToken;
        return this.accessToken;
    }
}
