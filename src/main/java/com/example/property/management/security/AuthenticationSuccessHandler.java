package com.example.property.management.security;

import com.example.property.management.web.dto.AdminSecurityDto;
import com.example.property.management.web.response.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author X
 */
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 更新用户最后一次登录成功的时间
        AdminSecurityDto principal = (AdminSecurityDto) authentication.getPrincipal();

        ApiResponse<AdminSecurityDto> apiResponse = ApiResponse.createSuccess(principal);
        String json = objectMapper.writeValueAsString(apiResponse);

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getOutputStream().write(json.getBytes("UTF-8"));
        response.getOutputStream().flush();
    }
}
