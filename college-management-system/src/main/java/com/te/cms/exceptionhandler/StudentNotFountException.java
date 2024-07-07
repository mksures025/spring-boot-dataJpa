package com.te.cms.exceptionhandler;

public class StudentNotFountException extends RuntimeException{

    String message;
    public StudentNotFountException(String message){
        super(message);
    }
}
