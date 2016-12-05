package com.ziiwee.support.wechat.qrcode;

import com.ziiwee.support.wechat.WeAccessToken;
import com.ziiwee.support.wechat.util.WeUtil;
import com.ziiwee.util.ZUtil;
import org.json.JSONObject;

/**
 * Created by ziiwee on 2016/12/5.
 */
public class WeQRCode {

    private final static String CREATE_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
    private final static String SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=";
    private final static String RESULT_PREFIX = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

    private WeAccessToken token;

    public WeQRCode(WeAccessToken token) {
        this.token = token;
    }

    public String createQRCode(long expireSeconds, long sceneId) {
        String url = CREATE_QRCODE_URL + WeUtil.getTokenValue(token);
        JSONObject params = new JSONObject();
        params.put("expire_seconds", expireSeconds);
        params.put("action_name", "QR_SCENE");
        params.put("action_info", new JSONObject().put("scene", new JSONObject().put("scene_id", sceneId)));
        JSONObject result = new JSONObject(ZUtil.Http.post(url, params.toString()));
        return RESULT_PREFIX + result.get("ticket").toString();
    }

    public String createNumberIdQRCode(long sceneId) {
        String url = CREATE_QRCODE_URL + WeUtil.getTokenValue(token);
        JSONObject params = new JSONObject();
        params.put("action_name", "QR_LIMIT_SCENE");
        params.put("action_info", new JSONObject().put("scene", new JSONObject().put("scene_id", sceneId)));
        JSONObject result = new JSONObject(ZUtil.Http.post(url, params.toString()));
        return RESULT_PREFIX + result.get("ticket").toString();
    }

    public String createStringIdQRCode(String sceneStr) {
        String url = CREATE_QRCODE_URL + WeUtil.getTokenValue(token);
        JSONObject params = new JSONObject();
        params.put("action_name", "QR_LIMIT_STR_SCENE");
        params.put("action_info", new JSONObject().put("scene", new JSONObject().put("scene_str", sceneStr)));
        JSONObject result = new JSONObject(ZUtil.Http.post(url, params.toString()));
        return RESULT_PREFIX + result.get("ticket").toString();
    }

    public String longToShort(String link) {
        String url = SHORT_URL + WeUtil.getTokenValue(token);
        JSONObject params = new JSONObject();
        params.put("action", "long2short");
        params.put("long_url", link);
        JSONObject result = new JSONObject(ZUtil.Http.post(url, params.toString()));
        return result.get("short_url").toString();
    }

}
