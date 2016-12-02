package com.ziiwee.support.wechat2.account;

import com.ziiwee.support.wechat2.WeAccessToken;
import com.ziiwee.support.wechat2.util.HttpRequestUtil;
import org.json.JSONObject;

/**
 * Created by ziiwee on 2016/11/28.
 */
public class WeAccountManagerBean implements WeAccountManager {

    private WeAccessToken token;

    public WeAccountManagerBean(WeAccessToken token) {
        this.token = token;
    }

    @Override
    public String createQRCode(long expireSeconds, String actionInfo, long sceneId) {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + token.getValue();
        JSONObject params = new JSONObject();
        params.put("expire_seconds", expireSeconds);
        params.put("action_name", "QR_SCENE");
        params.put("action_info", new JSONObject().put("scene", new JSONObject().put("scene_id", sceneId)));
        JSONObject result = new JSONObject(HttpRequestUtil.post(url, params.toString()));
        return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + result.get("ticket").toString();
    }

    @Override
    public String createNumberIdQRCode(String actionInfo, long sceneId) {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + token.getValue();
        JSONObject params = new JSONObject();
        params.put("action_name", "QR_LIMIT_SCENE");
        params.put("action_info", new JSONObject().put("scene", new JSONObject().put("scene_id", sceneId)));
        JSONObject result = new JSONObject(HttpRequestUtil.post(url, params.toString()));
        return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + result.get("ticket").toString();
    }

    @Override
    public String createStringIdQRCode(String actionInfo, String sceneStr) {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + token.getValue();
        JSONObject params = new JSONObject();
        params.put("action_name", "QR_LIMIT_STR_SCENE");
        params.put("action_info", new JSONObject().put("scene", new JSONObject().put("scene_str", sceneStr)));
        JSONObject result = new JSONObject(HttpRequestUtil.post(url, params.toString()));
        return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + result.get("ticket").toString();
    }

    @Override
    public String longToShort(String link) {
        String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + token.getValue();
        JSONObject params = new JSONObject();
        params.put("action", "long2short");
        params.put("long_url", link);
        JSONObject result = new JSONObject(HttpRequestUtil.post(url, params.toString()));
        return result.get("short_url").toString();
    }
}
