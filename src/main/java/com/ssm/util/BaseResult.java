package com.ssm.util;

/**
 * 接口信息
 */
public class BaseResult {
    //接口是否执行成功
    private boolean success;
    //接口执行结果
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
