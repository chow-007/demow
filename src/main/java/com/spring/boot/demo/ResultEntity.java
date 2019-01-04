package com.spring.boot.demo;

/**
 * @Auther: ZJS
 * @Date: 2018-11-14 16:45
 * @Description:  响应数据实体类
 */
public class ResultEntity<T> {

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应数据
     */
    private T result;

    public ResultEntity() {
    }

    public ResultEntity(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public ResultEntity(ResultCode resultCode, T result) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.result = result;
    }

    public ResultEntity(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public ResultEntity(int code, String msg, T result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", result=" + result +
                '}';
    }
}

