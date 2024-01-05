package com.example.study.springtx.ex;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/9/27
 */
public class BusinessException extends RuntimeException{

    private String message;

    private Throwable throwable;

    public BusinessException(String msgCode,Throwable throwable) {
        super(msgCode,throwable);
    }

}
