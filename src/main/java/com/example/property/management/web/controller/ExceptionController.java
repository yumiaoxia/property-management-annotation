package com.example.property.management.web.controller;

import com.example.property.management.exception.ErrorCode;
import com.example.property.management.exception.ServiceException;
import com.example.property.management.web.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * <p> </p>
 *
 * @author 俞淼霞
 * @since 2019-09-04
 */
@ControllerAdvice
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @Autowired
    private MessageSource messageSource;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        ApiResponse<Void> apiResponse = ApiResponse.createError(ErrorCode.SYSTEM_EXCEPTION);
        String message = messageSource.getMessage(apiResponse.getCode(), null, LocaleContextHolder.getLocale());
        apiResponse.setMessage(message);
        return apiResponse;
    }

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public ApiResponse<Void> handleServiceException(ServiceException ex) {
        log.error(ex.getMessage(), ex);

        Object[] variables = null;
        if (ex.getVariables() != null && ex.getVariables().length > 0) {
            variables = Arrays.stream(ex.getVariables())
                    .map(val -> messageSource.getMessage((String) val, null, LocaleContextHolder.getLocale())).toArray();
        }
        String message = messageSource.getMessage(ex.getErrorCode(), variables, LocaleContextHolder.getLocale());
        ApiResponse<Void> apiResponse = ApiResponse.createError(ex.getErrorCode());
        apiResponse.setMessage(message);
        return apiResponse;
    }


}
