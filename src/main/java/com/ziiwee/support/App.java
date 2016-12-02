package com.ziiwee.support;

import com.ziiwee.support.wechat2.SecretKeyWeAccessToken;
import com.ziiwee.support.wechat2.WeAccessToken;
import com.ziiwee.support.wechat2.account.WeAccountManager;
import com.ziiwee.support.wechat2.account.WeAccountManagerBean;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String appId = "wx4e4b2d0bffd36449";
        String appSecret = "d4624c36b6795d1d99dcf0547af5443d";
        WeAccessToken token = new SecretKeyWeAccessToken(appId, appSecret);

        WeAccountManager accountManager = new WeAccountManagerBean(token);

        String link = accountManager.createQRCode(9999, "123456", 1);
        System.out.println(link);
        System.out.println(accountManager.longToShort(link));
    }
}
