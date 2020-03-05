package com.example.property.management.web.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.constants.CommonConstants;
import com.example.property.management.entity.Admin;
import com.example.property.management.exception.ErrorCode;
import com.example.property.management.exception.ServiceException;
import com.example.property.management.service.IAdminService;
import com.example.property.management.utils.MyDtoTransformer;
import com.example.property.management.web.dto.AdminDto;
import com.itsherman.dto.assembler.utils.DtoTransFormer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AdminApplicationService {

    private final IAdminService adminService;

    public AdminApplicationService(IAdminService adminService) {
        this.adminService = adminService;
    }


    @Transactional(readOnly = true)
    public Page<AdminDto> list(Page<Admin> pageable) {
        Page<Admin> adminPage = adminService.page(pageable);
        return MyDtoTransformer.toPage(AdminDto.class).apply(adminPage);
    }

    @Transactional(readOnly = true)
    public AdminDto detail(String adminId) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_id", adminId);
        Admin admin = adminService.getOne(wrapper);
        if (admin == null) {
            throw ServiceException.of(ErrorCode.RESOURCE_NOT_FOUND, CommonConstants.ADMIN);
        }
        return DtoTransFormer.to(AdminDto.class).apply(admin);
    }
}
