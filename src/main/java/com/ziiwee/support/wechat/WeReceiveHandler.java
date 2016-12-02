package com.ziiwee.support.wechat;

import org.json.JSONObject;

/**
 * Created by ziiwee on 2016/11/30.
 * 内容处理
 */
public interface WeReceiveHandler {

    /**
     * 指示支持的类型。
     *
     * @return
     */
    WeReceiveType supportType();

    /**
     * 处理内容
     *
     * @param content
     * @return
     */
    String Handler(JSONObject content);

}
