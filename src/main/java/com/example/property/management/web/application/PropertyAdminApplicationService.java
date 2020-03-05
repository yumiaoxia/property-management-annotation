package com.example.property.management.web.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.property.management.constants.CommonConstants;
import com.example.property.management.entity.PropertyAdmin;
import com.example.property.management.exception.ErrorCode;
import com.example.property.management.exception.ServiceException;
import com.example.property.management.service.IPropertyAdminService;
import com.example.property.management.web.dto.ProAdminDto;
import com.itsherman.dto.assembler.utils.DtoTransFormer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PropertyAdminApplicationService {

    private final IPropertyAdminService propertyAdminService;


    public PropertyAdminApplicationService(IPropertyAdminService propertyAdminService) {
        this.propertyAdminService = propertyAdminService;
    }


    @Transactional(readOnly = true)
    public ProAdminDto detail(String adminId) {
        QueryWrapper<PropertyAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq("proadmin_id", adminId);
        PropertyAdmin propertyAdmin = propertyAdminService.getOne(wrapper);
        if (propertyAdmin == null) {
            throw ServiceException.of(ErrorCode.RESOURCE_NOT_FOUND, CommonConstants.PROPERTY_ADMIN);
        }
        return DtoTransFormer.to(ProAdminDto.class).apply(propertyAdmin);
    }
}
