package com.ziiwee.support.wechat.util;

/**
 * Created by ziiwee on 2016/11/28.
 */
public class Assert {

    public static void notNull(Object object) throws Exception {
        notNull(object, null);
    }

    public static void notNull(Object object, String message) throws Exception {
        if (object == null) {
            throw new Exception(message);
        }
    }

    public static void hasLength(String str) throws Exception {
        hasLength(str, null);
    }

    public static void hasLength(String str, String message) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception(message);
        }
    }

}
