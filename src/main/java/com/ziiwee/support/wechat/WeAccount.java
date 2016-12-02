package com.ziiwee.support.wechat;

/**
 * Created by ziiwee on 2016/11/30.
 * 微信号接口
 */
public interface WeAccount {

    public Integer getAuthType();

    public void setAuthType(Integer authType);

    public String getAppId();

    public void setAppId(String appId);

    public String getAccessToken();

    public void setAccessToken(String accessToken);

    public long getAccessTokenExpirationTime();

    public void setAccessTokenExpirationTime(long accessTokenExpirationTime);

    public String getRefreshToken();

    public void setRefreshToken(String refreshToken);

    public boolean isAuth1();

    public void setAuth1(boolean auth1);

    public boolean isAuth2();

    public void setAuth2(boolean auth2);

    public boolean isAuth3();

    public void setAuth3(boolean auth3);

    public boolean isAuth4();

    public void setAuth4(boolean auth4);

    public boolean isAuth5();

    public void setAuth5(boolean auth5);

    public boolean isAuth6();

    public void setAuth6(boolean auth6);

    public boolean isAuth7();

    public void setAuth7(boolean auth7);

    public boolean isAuth8();

    public void setAuth8(boolean auth8);

    public boolean isAuth9();

    public void setAuth9(boolean auth9);

    public boolean isAuth10();

    public void setAuth10(boolean auth10);

    public boolean isAuth11();

    public void setAuth11(boolean auth11);

    public boolean isAuth12();

    public void setAuth12(boolean auth12);

    public boolean isAuth13();

    public void setAuth13(boolean auth13);

    public boolean isAuth14();

    public void setAuth14(boolean auth14);

    public boolean isAuth15();

    public void setAuth15(boolean auth15);

    public String getNickname();

    public void setNickname(String nickname);

    public String getHeadImage();

    public void setHeadImage(String headImage);

    public String getServiceType();

    public void setServiceType(String serviceType);

    public Integer getVerifyType();

    public void setVerifyType(Integer verifyType);

    public String getUsername();

    public void setUsername(String username);

    public String getAlias();

    public void setAlias(String alias);

    public boolean isBusinessOpenStore();

    public void setBusinessOpenStore(boolean businessOpenStore);

    public boolean isBusinessOpenScan();

    public void setBusinessOpenScan(boolean businessOpenScan);

    public boolean isBusinessOpenPay();

    public void setBusinessOpenPay(boolean businessOpenPay);

    public boolean isBusinessOpenCard();

    public void setBusinessOpenCard(boolean businessOpenCard);

    public boolean isBusinessOpenShake();

    public void setBusinessOpenShake(boolean businessOpenShake);

    public String getQrcodeUrl();

    public void setQrcodeUrl(String qrcodeUrl);

    public Integer getLocationReport();

    public void setLocationReport(Integer locationReport);

    public Integer getVoiceRecognize();

    public void setVoiceRecognize(Integer voiceRecognize);

    public Integer getCustomerService();

    public void setCustomerService(Integer customerService);
    
}
