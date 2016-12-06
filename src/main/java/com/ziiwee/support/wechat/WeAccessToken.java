package com.ziiwee.support.wechat;

/**
 * Created by ziiwee on 2016/12/5.
 * 微信AccessToken
 * 实现类：
 *
 * @see SecretWeAccessToken
 */
public interface WeAccessToken {

    /**
     * 获取AccessToken的值
     *
     * @return
     */
    String getValue();

    /**
     * 创建或刷新AccessToken
     */
    void createOrRefresh();

    /**
     * 获取AccessToken的过期时间的时间戳
     *
     * @return
     */
    long getExpirationTime();

    /**
     * 获取AppId
     *
     * @return
     */
    String getAppId();


}
