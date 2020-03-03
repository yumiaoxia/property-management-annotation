package com.example.property.management.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.property.management.entity.Admin;
import com.example.property.management.service.IAdminService;
import com.example.property.management.web.dto.AdminSecurityDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    @Resource
    private IAdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_id", adminId);
        Admin admin = adminService.getById(adminId);
        if (admin == null) {
            throw new UsernameNotFoundException(String.format("Admin Not Found —— %s", adminId));
        }
        return new AdminSecurityDto(adminId, admin.getAdminName(), admin.getAdminPass(), Collections.singleton(new SimpleGrantedAuthority("ADMIN")));
    }
}
