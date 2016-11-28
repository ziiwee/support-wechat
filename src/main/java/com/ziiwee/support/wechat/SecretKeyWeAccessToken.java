package com.ziiwee.support.wechat;

/**
 * Created by ziiwee on 2016/11/28.
 */
public class SecretKeyWeAccessToken implements WeAccessToken {

    private String appId;

    private String appSecret;       //appSecret

    private String accessToken;     //令牌

    private long expirationTime;  //到期时间

    public SecretKeyWeAccessToken() {
    }

    public SecretKeyWeAccessToken(String appId, String appSecret, String accessToken, long expirationTime) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.accessToken = accessToken;
        this.expirationTime = expirationTime;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String getValue() {
        return this.accessToken;
    }
}
