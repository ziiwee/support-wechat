//package com.ziiwee.support.wechat.jssdk;
//
//import com.ziiwee.support.wechat.WeAccessToken;
//import com.ziiwee.support.wechat.util.WeUtil;
//import com.ziiwee.util.ZUtil;
//import com.ziiwee.util.detail.HttpRequestUtil;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Map;
//import java.util.UUID;
//
///**
// * Created by ziiwee on 2016/12/6.
// */
//public class WeJSSDK {
//
//    private WeAccessToken weAccessToken;
//
//    public WeJSSDK(WeAccessToken weAccessToken) {
//        this.weAccessToken = weAccessToken;
//    }
//
//    public JSONObject getWxConfig(String requestURL, Map<String, String[]> requestParameterMap) {
//        String url = requestURL + toParams(requestParameterMap);
//        JSONObject weixinConfig = new JSONObject();
//        weixinConfig.put("debug", false);
//        weixinConfig.put("appId", weAccessToken.getAppId());
//        weixinConfig.put("timestamp", new Date().getTime() + "");
//        weixinConfig.put("nonceStr", UUID.randomUUID().toString().replace("-", ""));
//        weixinConfig.put("signature", sign(ticket, timestamp, nonceStr, url));
//        weixinConfig.put("jsApiList", new JSONArray("['onMenuShareTimeline','onMenuShareAppMessage','getLocation']"));
//    }
//
//
//    private String getTicket() {
//        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
//        url += WeUtil.getTokenValue(weAccessToken);
//        url += "&type=jsapi";
//        ticket = new JSONObject(HttpRequestUtil.get(url)).get("ticket").toString();
//        request.getSession().setAttribute("TICKET", ticket);
//    }
//
//    private String toParams(Map map) {
//        String params = "";
//        for (Object key : map.keySet()) {
//            System.out.println("key=" + key);
//            String[] value = (String[]) map.get(key);
//            for (String v : value) {
//                System.out.println("value=" + v);
//            }
//            params += key + "=" + value[0] + "&";
//        }
//        if (params.length() > 0) {
//            params = "?" + params.substring(0, params.length() - 1);
//        }
//        return params;
//    }
//
//    private String sign(String ticket, String timestamp, String nonceStr, String path) {
//        JSONObject jo = new JSONObject();
//        jo.put("noncestr", nonceStr);
//        jo.put("jsapi_ticket", ticket);
//        jo.put("timestamp", timestamp);
//        jo.put("url", path);
//        return createSign(jo);
//    }
//
//    private String createSign(JSONObject param) {
//        StringBuilder sb = new StringBuilder();
//
//        String[] str = new String[param.length()];
//        int i = 0;
//        for (Object o : param.keySet()) {
//            str[i] = o.toString();
//            i++;
//        }
//        Arrays.sort(str);
//        for (String k : str) {
//            String v = param.get(k).toString();
//            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
//                sb.append(k).append("=").append(v).append("&");
//            }
//        }
//        String sbStr = sb.toString();
//        sbStr = sbStr.substring(0, (sbStr.length() - 1));
//        return ZUtil.Security.sha1(sbStr);
//    }
//}
