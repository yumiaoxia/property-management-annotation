package com.example.property.management.security;

/**
 * @author X
 */
public class LoginRequiredResponse {

    public static final LoginRequiredResponse RESPONSE = new LoginRequiredResponse();

    public String getCode() {
        return "1000";
    }

    public String getMessage() {
        return "请先登录";
    }
}
