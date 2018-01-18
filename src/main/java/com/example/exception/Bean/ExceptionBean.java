package com.example.exception.Bean;

/**
 * 异常信息实体类
 *
 * @Author xierh
 * @Date 2018/1/18/018 17:39
 */
public class ExceptionBean {
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

    public ExceptionBean (){
    }
    public ExceptionBean (String errorMessage){
        super();
        this.errorMessage = errorMessage;
    }
    public ExceptionBean (Integer errorCode,String errorMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public ExceptionBean (Integer errorCode,String errorMessage,Object errorData){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorData = errorData;
    }
}
