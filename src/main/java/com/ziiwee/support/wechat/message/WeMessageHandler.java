package com.ziiwee.support.wechat.message;

/**
 * Created by ziiwee on 2016/11/28.
 */
public interface WeMessageHandler {

    /**
     * 文本消息
     *
     * @param message
     * @return
     */
    WeMessage text(String message);

    /**
     * 图片消息
     *
     * @param message
     * @return
     */
    WeMessage image(String message);

    /**
     * 语言消息
     *
     * @param message
     * @return
     */
    WeMessage voice(String message);

    /**
     * 视频消息
     *
     * @param message
     * @return
     */
    WeMessage video(String message);

    /**
     * 小视频消息
     *
     * @param message
     * @return
     */
    WeMessage shortVideo(String message);

    /**
     * 地理位置消息
     *
     * @param message
     * @return
     */
    WeMessage location(String message);

    /**
     * 链接消息
     *
     * @param message
     * @return
     */
    WeMessage link(String message);
}
