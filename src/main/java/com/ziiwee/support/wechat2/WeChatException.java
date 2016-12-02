package com.ziiwee.support.wechat2;

/**
 * Created by ziiwee on 2016/11/28.
 */
public class WeChatException extends RuntimeException {

    public WeChatException(String message) {
        super(message);
    }

    public WeChatException(Throwable cause) {
        super(cause);
    }

    public WeChatException(String message, Throwable cause) {
        super(message, cause);
    }

}
