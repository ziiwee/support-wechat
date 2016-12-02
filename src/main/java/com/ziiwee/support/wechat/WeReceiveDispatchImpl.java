package com.ziiwee.support.wechat;

import org.json.JSONObject;
import org.json.XML;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziiwee on 2016/11/30.
 */
public class WeReceiveDispatchImpl implements WeReceiveDispatch {

    private Map<WeReceiveType, WeReceiveHandler> map = Collections.emptyMap();

    public WeReceiveDispatchImpl(){
        map = new HashMap<>();

    }

    @Override
    public String dispatch(String content) {
        try {

            System.out.println("-----------dispatch-----------");

            JSONObject receive = XML.toJSONObject(content).getJSONObject("xml");
            WeReceiveType receiveType;
            if ("event".equals(receive.get("MsgType").toString())) {
                receiveType = WeReceiveType.parser(receive.get("Event").toString());
            } else {
                receiveType = WeReceiveType.parser(receive.get("MsgType").toString());
            }
            WeReceiveHandler handler = map.get(receiveType);
            if (handler == null) {
                throw new Exception();
            }
            String message = map.get(receiveType).Handler(receive);
            if (message == null) {
                throw new Exception();
            }
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            return "success";
        }
    }

    @Override
    public void registerReceiveHandler(WeReceiveHandler receiveHandler) {
        map.put(receiveHandler.supportType(), receiveHandler);
    }

}
