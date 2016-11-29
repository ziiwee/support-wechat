package com.ziiwee.support;

import com.ziiwee.support.wechat.SecretKeyWeAccessTokenFactoryBean;
import com.ziiwee.support.wechat.WeAccessToken;
import com.ziiwee.support.wechat.WeAccessTokenFactory;
import com.ziiwee.support.wechat.account.WeAccountManager;
import com.ziiwee.support.wechat.account.WeAccountManagerBean;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String appId = "wx4e4b2d0bffd36449";
        String appSer = "d4624c36b6795d1d99dcf0547af5443d";
        WeAccessTokenFactory tokenFactory = new SecretKeyWeAccessTokenFactoryBean(appId, appSer);
        WeAccessToken token = tokenFactory.getCurrentAccessToken(appId);
        WeAccountManager wam = new WeAccountManagerBean(tokenFactory);

        System.out.println("--->" + token.getValue());
        System.out.println("--->"+wam.createQRCode(30000,"ddw",123));

    }
}
