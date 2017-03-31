package com.zxzq.eventbusdemo;

/**
 * Created by Sainmon on 2017/3/31.
 */

public class MyEvent {
    private String msg;
    public MyEvent(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
}
