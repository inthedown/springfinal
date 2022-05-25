package com.zucc.Exception;

public class EchoServiceException extends RuntimeException{
    public EchoServiceException(){};

    public EchoServiceException(String msg){
        super(msg);
    };
}
