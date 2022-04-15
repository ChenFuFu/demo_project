package com.example.dynamic_data_source.exception;

/**
 * @Author Chen
 * @Date 2022/4/15
 * @Time 09:36
 * @Description
 */

public class BDException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public BDException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BDException(Throwable cause, String msg) {
        super(msg, cause);
        this.msg = msg;
    }

    public BDException(String message, Throwable cause) {
        super(message, cause);
        this.msg = message;
    }

    public BDException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BDException(Throwable cause, String msg, int code) {
        super(msg, cause);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
