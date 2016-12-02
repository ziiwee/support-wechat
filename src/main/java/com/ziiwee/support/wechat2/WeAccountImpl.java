package com.ziiwee.support.wechat2;

/**
 * Created by ziiwee on 2016/12/2.
 */
public class WeAccountImpl implements WeAccount {

    private Integer authType;   //授权状态 0:未授权 1:授权成功 2:取消授权

    private String appId;

    private String accessToken;

    private long accessTokenExpirationTime;

    private String refreshToken;   //刷新令牌

    private boolean auth1 = false;  //消息管理权限
    private boolean auth2 = false;  //用户管理权限
    private boolean auth3 = false;  //帐号服务权限
    private boolean auth4 = false;  //网页服务权限
    private boolean auth5 = false;  //微信小店权限
    private boolean auth6 = false;  //微信多客服权限
    private boolean auth7 = false;  //群发与通知权限
    private boolean auth8 = false;  //微信卡券权限
    private boolean auth9 = false;  //微信扫一扫权限
    private boolean auth10 = false; //微信连WIFI权限
    private boolean auth11 = false; //素材管理权限
    private boolean auth12 = false; //微信摇周边权限
    private boolean auth13 = false; //微信门店权限
    private boolean auth14 = false; //微信支付权限
    private boolean auth15 = false; //自定义菜单权限


    //--------------以下为详细信息--------------

    private String nickname;        //授权方昵称

    private String headImage;       //授权方头像
    private String serviceType;     //授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号

    /**
     * 授权方认证类型，
     * -1代表未认证，0代表微信认证，
     * 1代表新浪微博认证，2代表腾讯微博认证，
     * 3代表已资质认证通过但还未通过名称认证，
     * 4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，
     * 5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
     */
    private Integer verifyType;

    private String username;        //授权方公众号的原始ID
    private String alias;           //授权方公众号所设置的微信号，可能为空

    private boolean businessOpenStore;    //是否开通微信门店功能
    private boolean businessOpenScan;    //是否开通微信扫商品功能
    private boolean businessOpenPay;    //是否开通微信支付功能
    private boolean businessOpenCard;    //是否开通微信卡券功能
    private boolean businessOpenShake;    //是否开通微信摇一摇功能

    private String qrcodeUrl;

    private Integer locationReport;     //地理位置上报选项 0:无上报 1:进入会话时上报 2:每5s上报
    private Integer voiceRecognize;     //语音识别开关选项 0:关闭语音识别 1:开启语音识别
    private Integer customerService;    //多客服开关选项 0:关闭多客服 1:开启多客服


    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getAccessTokenExpirationTime() {
        return accessTokenExpirationTime;
    }

    public void setAccessTokenExpirationTime(long accessTokenExpirationTime) {
        this.accessTokenExpirationTime = accessTokenExpirationTime;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public boolean isAuth1() {
        return auth1;
    }

    public void setAuth1(boolean auth1) {
        this.auth1 = auth1;
    }

    public boolean isAuth2() {
        return auth2;
    }

    public void setAuth2(boolean auth2) {
        this.auth2 = auth2;
    }

    public boolean isAuth3() {
        return auth3;
    }

    public void setAuth3(boolean auth3) {
        this.auth3 = auth3;
    }

    public boolean isAuth4() {
        return auth4;
    }

    public void setAuth4(boolean auth4) {
        this.auth4 = auth4;
    }

    public boolean isAuth5() {
        return auth5;
    }

    public void setAuth5(boolean auth5) {
        this.auth5 = auth5;
    }

    public boolean isAuth6() {
        return auth6;
    }

    public void setAuth6(boolean auth6) {
        this.auth6 = auth6;
    }

    public boolean isAuth7() {
        return auth7;
    }

    public void setAuth7(boolean auth7) {
        this.auth7 = auth7;
    }

    public boolean isAuth8() {
        return auth8;
    }

    public void setAuth8(boolean auth8) {
        this.auth8 = auth8;
    }

    public boolean isAuth9() {
        return auth9;
    }

    public void setAuth9(boolean auth9) {
        this.auth9 = auth9;
    }

    public boolean isAuth10() {
        return auth10;
    }

    public void setAuth10(boolean auth10) {
        this.auth10 = auth10;
    }

    public boolean isAuth11() {
        return auth11;
    }

    public void setAuth11(boolean auth11) {
        this.auth11 = auth11;
    }

    public boolean isAuth12() {
        return auth12;
    }

    public void setAuth12(boolean auth12) {
        this.auth12 = auth12;
    }

    public boolean isAuth13() {
        return auth13;
    }

    public void setAuth13(boolean auth13) {
        this.auth13 = auth13;
    }

    public boolean isAuth14() {
        return auth14;
    }

    public void setAuth14(boolean auth14) {
        this.auth14 = auth14;
    }

    public boolean isAuth15() {
        return auth15;
    }

    public void setAuth15(boolean auth15) {
        this.auth15 = auth15;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(Integer verifyType) {
        this.verifyType = verifyType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isBusinessOpenStore() {
        return businessOpenStore;
    }

    public void setBusinessOpenStore(boolean businessOpenStore) {
        this.businessOpenStore = businessOpenStore;
    }

    public boolean isBusinessOpenScan() {
        return businessOpenScan;
    }

    public void setBusinessOpenScan(boolean businessOpenScan) {
        this.businessOpenScan = businessOpenScan;
    }

    public boolean isBusinessOpenPay() {
        return businessOpenPay;
    }

    public void setBusinessOpenPay(boolean businessOpenPay) {
        this.businessOpenPay = businessOpenPay;
    }

    public boolean isBusinessOpenCard() {
        return businessOpenCard;
    }

    public void setBusinessOpenCard(boolean businessOpenCard) {
        this.businessOpenCard = businessOpenCard;
    }

    public boolean isBusinessOpenShake() {
        return businessOpenShake;
    }

    public void setBusinessOpenShake(boolean businessOpenShake) {
        this.businessOpenShake = businessOpenShake;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public Integer getLocationReport() {
        return locationReport;
    }

    public void setLocationReport(Integer locationReport) {
        this.locationReport = locationReport;
    }

    public Integer getVoiceRecognize() {
        return voiceRecognize;
    }

    public void setVoiceRecognize(Integer voiceRecognize) {
        this.voiceRecognize = voiceRecognize;
    }

    public Integer getCustomerService() {
        return customerService;
    }

    public void setCustomerService(Integer customerService) {
        this.customerService = customerService;
    }

    @Override
    public String getReliableAccessToken() {
        return null;
    }
}
