package com.example.property.management.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class NoPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        //不做任何加密处理
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        if (charSequence.toString().equals(s)) {
            return true;
        }
        return false;
    }
}