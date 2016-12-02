package com.ziiwee.support.wechat2;

/**
 * Created by ziiwee on 2016/11/29.
 * 微信AccessToken抽象类
 */
public abstract class AbstractWeAccessToken implements WeAccessToken {

    @Override
    public String getValue() {
        String token = getCurrentWeAccessToken();
        token = token == null ? createWeAccessToken() : token;
        return isExpiredWeAccessToken() ? refreshWeAccessToken() : token;
    }

    public abstract String createWeAccessToken();

    public abstract String refreshWeAccessToken();

    public abstract String getCurrentWeAccessToken();

    public abstract boolean isExpiredWeAccessToken();

}
