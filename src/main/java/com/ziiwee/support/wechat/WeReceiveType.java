package com.ziiwee.support.wechat;

import java.util.Objects;

/**
 * Created by ziiwee on 2016/11/30.
 * 收到的微信推送内容类型
 */
public enum WeReceiveType {

    TEXT("text"),               //文本
    IMAGE("image"),             //图片
    VOICE("voice"),             //语言
    VIDEO("video"),             //视频
    SHORT_VIDEO("shortvideo"),  //小视频
    LOCATION("location"),       //地理位置
    LINK("link"),               //链接
    EVENT_SUBSCRIBE("subscribe"),                 //订阅
    EVENT_UNSUBSCRIBE("unsubscribe"),             //取消订阅
    EVENT_SCAN("SCAN"),                           //扫描带参数二维码事件(已关注时扫描)
    EVENT_LOCATION("LOCATION"),                   //上报地理位置事件
    EVENT_CLICK("CLICK"),                         //自定义菜单事件:点击菜单拉取消息时的事件推送
    EVENT_VIEW("VIEW"),                           //自定义菜单事件:点击菜单跳转链接时的事件推送
    EVENT_QUALIFICATION_VERIFY_SUCCESS("qualification_verify_success"),   //资质认证成功（此时立即获得接口权限）
    EVENT_QUALIFICATION_VERIFY_FAIL("qualification_verify_fail"),         //资质认证失败
    EVENT_NAMING_VERIFY_SUCCESS("naming_verify_success"),                 //名称认证成功（即命名成功）
    EVENT_NAMING_VERIFY_FAIL("naming_verify_fail"),           //名称认证失败（这时虽然客户端不打勾，但仍有接口权限）
    EVENT_ANNUAL_RENEW("annual_renew"),                       //年审通知
    EVENT_VERIFY_EXPIRED("verify_expired");                   //认证过期失效通知

    private String value;

    public String getValue() {
        return value;
    }

    WeReceiveType(String desc) {
        this.value = desc;
    }

    public static WeReceiveType parser(String value) {
        WeReceiveType result = null;
        for (WeReceiveType type : WeReceiveType.values()) {
            if (Objects.equals(type.getValue(), value)) {
                result = type;
            }
        }
        return result;
    }
}
