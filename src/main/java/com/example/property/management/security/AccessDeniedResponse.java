package com.example.property.management.security;

/**
 * @author X
 */
public class AccessDeniedResponse {

    public static final AccessDeniedResponse RESPONSE = new AccessDeniedResponse();

    public String getCode() {
        return "1010";
    }

    public String getMessage() {
        return "权限不足";
    }

}
