package com.example.property.management.web.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AdminSecurityDto extends User {

    private String adminName;

    public AdminSecurityDto(String adminId, String adminName, String password, Collection<? extends GrantedAuthority> authorities) {
        super(adminId, password, authorities);
        this.adminName = adminName;
    }

    public AdminSecurityDto(String adminId, String adminName, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(adminId, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }
}
