package com.qxl.mvpproject.utils.netUtils;

/**
 * Created by xiaoling on 2017/2/20.
 * 要求服务器返回格式为:
  {
      code : 200
      message : success
      response : {}
  }
 */
public class ApiResult<T> {
    private int code;
    private String message;
    private T response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", response=" + response +
                '}';
    }
}
