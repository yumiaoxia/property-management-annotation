package com.example.property.management.security;

import com.example.property.management.exception.ErrorCode;
import com.example.property.management.web.response.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * @author X
 */
public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {

    public static final String MESSAGE_CODE_PREFIX = "authenticationException.";

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFailureHandler.class);

    private ObjectMapper objectMapper;

    private MessageSource messageSource;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Called when an authentication attempt fails.
     *
     * @param request   the request during which the authentication attempt occurred.
     * @param response  the response.
     * @param exception the exception which was thrown to reject the authentication
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
// 通过异常的类型，从 MessageSource 中找到对应的消息代码
        Class<?> ex = exception.getClass();
        Locale locale = Locale.CHINESE;
        String message = null;

        while (!ex.equals(AuthenticationException.class.getSuperclass())) {
            String exceptionName = ex.getSimpleName();
            String code = MESSAGE_CODE_PREFIX + exceptionName;
            Object[] args = null;
            if (AuthenticationExceptionArgumentsProvider.class.isAssignableFrom(ex)) {
                args = ((AuthenticationExceptionArgumentsProvider) exception).getArguments();
            }
            logger.debug("尝试获取消息编码{}以确定认证失败信息", code);
            message = messageSource.getMessage(code, args, null, locale);
            if (message == null) {
                ex = ex.getSuperclass();
            } else {
                break;
            }
        }

        if (message == null) {
            logger.debug("无法找到针对异常类型{}可用的消息编码。使用默认的错误消息。", exception.getClass());
            message = "认证错误";
        }

        ApiResponse<Void> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ErrorCode.AUTHENTICATION_ERROR);
        apiResponse.setMessage(message);

        String json = objectMapper.writeValueAsString(apiResponse);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getOutputStream().write(json.getBytes("UTF-8"));
        response.getOutputStream().flush();
    }
}
