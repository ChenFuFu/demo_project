package com.example.dynamic_data_source.exception;

/**
 * @Author Chen
 * @Date 2022/4/15
 * @Time 09:36
 * @Description 自定义异常类
 */

public class BDException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;
    private int code = 500;

    public BDException(String msg) {
        super(msg);
        this.message = msg;
    }

    public BDException(Throwable cause, String msg) {
        super(msg, cause);
        this.message = msg;
    }

    public BDException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public BDException(String msg, int code) {
        super(msg);
        this.message = msg;
        this.code = code;
    }

    public BDException(Throwable cause, String msg, int code) {
        super(msg, cause);
        this.message = msg;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
