package com.dl.officialsite.common.advice;


import com.dl.officialsite.common.base.BaseResponse;
import com.dl.officialsite.common.exception.BizException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse handleMethodArgumentNotValidException(HttpServletRequest req, Exception e)
            throws JsonProcessingException {
        log.error("", e);
        if (e instanceof BizException) {
            BizException bizException = (BizException) e;
            return BaseResponse.failWithReason(bizException.getCode(), bizException.getMsg());
        }
        return BaseResponse.failWithReason("99999", e.getMessage());
    }

}
