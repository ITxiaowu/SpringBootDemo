package com.example.exception;

import com.example.exception.Bean.ExceptionBean;
import com.example.exception.Bean.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理：
 * 可选择实现error.html页面展示或者返回json
 *
 * @Author xierh
 * @Date 2018/1/18/018 17:37
 */
@ControllerAdvice
public class BaseExceptionController {
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 统一异常处理：实现error.html页面展示
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    // @ExceptionHandler用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
    @ExceptionHandler(value = MyException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorCode", e.getErrorCode());
        mav.addObject("errorMessage", e.getErrorMessage());
        mav.addObject("exception", e.getMessage());
        mav.addObject("errorUrl", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * 统一异常处理：返回JSON格式
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    /*@ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ExceptionBean jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ExceptionBean eb = new ExceptionBean();

        eb.setErrorMessage(e.getErrorMessage());
        eb.setErrorData(e.getErrorData());
        eb.setErrorCode(e.getErrorCode());
        eb.setErrorUrl(req.getRequestURL().toString());
        return eb;
    }*/
}