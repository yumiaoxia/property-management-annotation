package com.example.property.management.web.application;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.entity.Admin;
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
        Admin admin = adminService.getById(adminId);
        return DtoTransFormer.to(AdminDto.class).apply(admin);
    }
}
