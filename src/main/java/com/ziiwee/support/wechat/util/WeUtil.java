package com.ziiwee.support.wechat.util;

import com.ziiwee.support.wechat.WeAccessToken;
import com.ziiwee.util.ZUtil;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by ziiwee on 2016/12/5.
 */
public class WeUtil {

    public static String getTokenValue(WeAccessToken token) {
        if (token.getValue() == null || isExpired(token)) {
            token.createOrRefresh();
        }
        return token.getValue();
    }

    public static boolean isExpired(WeAccessToken token) {
        return new Date().after(new Date(token.getExpirationTime() - 200 * 1000L));
    }

    public static JSONObject getWeAccessTokenByAppSecret(String appId, String appSecret) {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
        url += "&appid=" + appId;
        url += "&secret=" + appSecret;
        return new JSONObject(ZUtil.Http.get(url));
    }

}
