package com.example.property.management.web.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AdminSecurityDto extends User {

    private String adminId;

    private Integer adminType;

    public AdminSecurityDto(String adminId, String adminName, Integer adminType, String password, Collection<? extends GrantedAuthority> authorities) {
        super(adminName, password, authorities);
        this.adminId = adminId;
        this.adminType = adminType;
    }

    public AdminSecurityDto(String adminId, String adminName, Integer adminType, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(adminName, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.adminId = adminId;
        this.adminType = adminType;
    }

    public String getAdminId() {
        return adminId;
    }

    public Integer getAdminType() {
        return adminType;
    }
}
