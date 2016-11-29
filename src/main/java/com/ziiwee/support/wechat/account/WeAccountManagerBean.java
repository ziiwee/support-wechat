package com.ziiwee.support.wechat.account;

import com.ziiwee.support.wechat.WeAccessTokenFactory;

/**
 * Created by ziiwee on 2016/11/28.
 */
public class WeAccountManagerBean implements WeAccountManager {

    private WeAccessTokenFactory tokenFactory;

    public WeAccountManagerBean(WeAccessTokenFactory tokenFactory) {
        this.tokenFactory = tokenFactory;
    }

    @Override
    public String createQRCode(long expireSeconds, String actionInfo, long sceneId) {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + tokenFactory
                .getCurrentAccessToken("").getValue();
        return null;
    }

    @Override
    public String createPermanentQRCode(String actionInfo, long sceneId, String sceneStr) {
        return null;
    }

    @Override
    public String long2short(String url) {
        return null;
    }
}
