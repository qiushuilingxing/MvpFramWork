package com.qxl.mvpproject.utils.netUtils;

/**
 * Created by xiaoling on 2017/2/20.
 * 获取服务器返回的所有内容,使用本类的地方,根据本类的code做相应处理
 */
public class ApiException extends RuntimeException {
    private int code;
    private String message;
    private String response;

    public ApiException(int code, String msg, String response) {
        super(code+"---"+msg+"--"+response);
        this.code = code;
        this.message = msg;
        this.response = response;

    }

    public ApiException() {
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
