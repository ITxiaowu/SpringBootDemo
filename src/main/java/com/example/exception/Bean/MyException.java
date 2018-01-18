package com.example.exception.Bean;

/**
 * 异常捕获类
 *
 * 该类与异常实体类ExceptionBean基本；
 * 区别在于：ExceptionBean未继承至Exception
 * 原因：MyException已经继承了Exception，ExceptionBean只用于将MyException捕获的异常信息转化为普通类；
 *      ExceptionBean如果再继承Exception，则json串中会打印多条重复异常
 */
public class MyException extends Exception {

    private Integer errorCode = 1001;   // 异常码
    private String errorMessage; // 异常信息
    private Object errorData;    // 异常时请求的数据
    private String errorUrl;     // 异常时请求的路径

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }

    public MyException (){
    }
    public MyException (String errorMessage){
        super();
        this.errorMessage = errorMessage;
    }
    public MyException (Integer errorCode,String errorMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public MyException (Integer errorCode,String errorMessage,Object errorData){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorData = errorData;
    }

}