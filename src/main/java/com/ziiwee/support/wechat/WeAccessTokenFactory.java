package com.ziiwee.support.wechat;

/**
 * Created by ziiwee on 2016/11/28.
 * 微信授权令牌
 */
public interface WeAccessTokenFactory {

    /**
     * 获取AccessToken(没有则先创建，自动刷新)
     *
     * @param appId
     * @return
     */
    WeAccessToken getCurrentAccessToken(String appId);

    /**
     * 强制刷新AccessToken
     *
     * @param appId
     * @return
     */
    WeAccessToken refreshAccessToken(String appId);

}
