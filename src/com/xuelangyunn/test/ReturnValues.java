package com.xuelangyunn.test;

import com.alibaba.fastjson.JSONArray;

/**
 * @author shkstart
 * @create 2021-04-29 15:09
 */
public class ReturnValues {
    private String status;
    private String msg;
    private JSONArray data;

    public ReturnValues() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReturnValues{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}


