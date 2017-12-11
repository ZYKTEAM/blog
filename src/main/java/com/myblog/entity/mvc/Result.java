package com.myblog.entity.mvc;



/**
 * Created by yhy on 2017/4/1.
 */
public class Result {
    /** 状态*/
    private Boolean status;

    /** 错误码. */
    private String code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
