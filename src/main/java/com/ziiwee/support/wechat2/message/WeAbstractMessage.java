package com.ziiwee.support.wechat2.message;

/**
 * Created by ziiwee on 2016/11/28.
 */
public abstract class WeAbstractMessage implements WeMessage {

    private String toUserName;      //接收方帐号（收到的OpenID）

    private String fromUserName;    //开发者微信号

    private String createTime;      //消息创建时间 （整型）

    private String messageType;     //消息类型

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
