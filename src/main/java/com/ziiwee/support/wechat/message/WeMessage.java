package com.ziiwee.support.wechat.message;

/**
 * Created by ziiwee on 2016/11/28.
 */
public interface WeMessage {

    void parser(String xmlMessage);

    String toXmlMessage();

}
