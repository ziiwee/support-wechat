package com.ziiwee.support.wechat.account;

/**
 * Created by ziiwee on 2016/11/28.
 */
public interface WeAccountManager {

    /**
     * 临时二维码
     *
     * @param expireSeconds 有效时间
     * @param actionInfo    二维码详细信息
     * @param sceneId       场景值ID
     * @return
     */
    String createQRCode(long expireSeconds, String actionInfo, long sceneId);

    /**
     * 永久二维码
     *
     * @param actionInfo
     * @param sceneId
     * @param sceneStr
     * @return
     */
    String createPermanentQRCode(String actionInfo, long sceneId, String sceneStr);

    /**
     * 长链接转短链接
     *
     * @param url
     * @return
     */
    String long2short(String url);
}
