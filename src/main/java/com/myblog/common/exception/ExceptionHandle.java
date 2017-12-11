package com.myblog.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *全局异常统一处理
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Log log = LogFactory.getLog(ExceptionHandle.class);

    @ExceptionHandler(value = java.lang.Exception.class)
    public String handle(Exception e,Model model) {
        BusinessException businessException = (BusinessException) e;
        model.addAttribute("message",e.getMessage());
        return "error";
    }
}
