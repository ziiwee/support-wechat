package com.ziiwee.support.wechat;

/**
 * Created by ziiwee on 2016/11/28.
 */
public class WeChatException extends RuntimeException {

    /**
     * Constructs a HibernateException using the given exception message.
     *
     * @param message The message explaining the reason for the exception
     */
    public WeChatException(String message) {
        super(message);
    }

    /**
     * Constructs a HibernateException using the given message and underlying cause.
     *
     * @param cause The underlying cause.
     */
    public WeChatException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a HibernateException using the given message and underlying cause.
     *
     * @param message The message explaining the reason for the exception.
     * @param cause   The underlying cause.
     */
    public WeChatException(String message, Throwable cause) {
        super(message, cause);
    }

}
