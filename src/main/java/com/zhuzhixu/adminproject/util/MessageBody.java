package com.zhuzhixu.adminproject.util;

/**
 *  ajax json 返回数据封装
 */
public class MessageBody {
    private boolean status;
    private String message;
    private Object data;

    public MessageBody(boolean status, String message){
        this.status = status;
        this.message = message;
    }

    public MessageBody(boolean status, Object data){
        this.status = status;
        this.data = data;
    }

    public MessageBody(boolean status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static MessageBody successMessage(String message){
        return new MessageBody(true,message);
    }

    public static MessageBody successMessage(String message, Object data){
        return new MessageBody(true,message,data);
    }

    public static MessageBody failMessage(String message){
        return new MessageBody(false, message);
    }

    public static MessageBody failMessage(String message, Object data){
        return new MessageBody(false, message, data);
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
