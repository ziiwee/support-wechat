package com.ziiwee.support.wechat2.account;

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
     * 永久二维码(数字ID)
     *
     * @param actionInfo
     * @param sceneId
     * @return
     */
    String createNumberIdQRCode(String actionInfo, long sceneId);

    /**
     * 永久二维码(字符串ID)
     *
     * @param actionInfo
     * @param sceneStr
     * @return
     */
    String createStringIdQRCode(String actionInfo, String sceneStr);

    /**
     * 长链接转短链接
     *
     * @param link
     * @return
     */
    String longToShort(String link);
}
