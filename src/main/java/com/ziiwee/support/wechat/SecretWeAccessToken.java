package com.ziiwee.support.wechat;

import com.ziiwee.support.wechat.util.WeUtil;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by ziiwee on 2016/11/28.
 */
public class SecretWeAccessToken implements WeAccessToken {


    private String appId;

    private String appSecret;       //appSecret

    private String accessToken;     //令牌

    private long expirationTime;  //到期时间

    public SecretWeAccessToken(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }


    @Override
    public void createOrRefresh() {
        try {
            JSONObject jo = WeUtil.getWeAccessTokenByAppSecret(this.appId, this.appSecret);
            try {
                this.accessToken = jo.get("access_token").toString();
                this.expirationTime = new Date().getTime() + 7200 * 1000L;
            } catch (Exception e) {
                throw new WeChatException(e.getMessage() + "错误信息: " + jo.get("errmsg").toString());
            }
        } catch (Exception e) {
            throw new WeChatException("创建AccessToken失败: " + e.getMessage());
        }
    }

    @Override
    public String getValue() {
        return this.accessToken;
    }

    @Override
    public long getExpirationTime() {
        return this.expirationTime;
    }

    @Override
    public String getAppId() {
        return this.appId;
    }
}
