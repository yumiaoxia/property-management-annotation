package com.example.property.management.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.property.management.entity.Admin;
import com.example.property.management.entity.PropertyAdmin;
import com.example.property.management.service.IAdminService;
import com.example.property.management.web.dto.AdminSecurityDto;
import org.springframework.security.authentication.AuthenticationServiceException;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String[] usernameData = username.split("-");
        String roleCode = usernameData[0];

        if (roleCode.equals("1")) {
            String adminId = usernameData[1];
            QueryWrapper<Admin> wrapper = new QueryWrapper<>();
            wrapper.eq("admin_id", adminId);
            Admin admin = adminService.getOne(wrapper);
            if (admin == null) {
                throw new UsernameNotFoundException(String.format("Admin Not Found —— %s", adminId));
            }
            return new AdminSecurityDto(adminId, admin.getAdminName(), Integer.valueOf(roleCode), admin.getAdminPass(), Collections.singleton(new SimpleGrantedAuthority("ADMIN")));
        } else if (roleCode.equals("2")) {
            String proAdminId = usernameData[1];
            QueryWrapper<PropertyAdmin> wrapper = new QueryWrapper<>();
            wrapper.eq("proadmin_id", proAdminId);
            PropertyAdmin propertyAdmin = new PropertyAdmin();
            if (propertyAdmin == null) {
                throw new UsernameNotFoundException(String.format("Admin Not Found —— %s", proAdminId));
            }
            return new AdminSecurityDto(proAdminId, propertyAdmin.getProadminName(), Integer.valueOf(roleCode), propertyAdmin.getProadminPass(), Collections.singleton(new SimpleGrantedAuthority("PROADMIN")));
        } else {
            throw new AuthenticationServiceException("用户类型不存在");
        }
    }
}
