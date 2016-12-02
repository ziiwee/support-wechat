package com.ziiwee.support.wechat;

/**
 * Created by ziiwee on 2016/11/30.
 */
public interface WeReceiveDispatch {

    String dispatch(String content);

    void registerReceiveHandler(WeReceiveHandler receiveHandler);

}
