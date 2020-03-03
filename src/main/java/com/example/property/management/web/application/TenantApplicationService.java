package com.example.property.management.web.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.constants.CommonConstants;
import com.example.property.management.entity.Tenant;
import com.example.property.management.exception.ErrorCode;
import com.example.property.management.exception.ServiceException;
import com.example.property.management.service.ITenantService;
import com.example.property.management.utils.MyDtoTransformer;
import com.example.property.management.web.command.KeywordSearchCommand;
import com.example.property.management.web.command.TenantCreate;
import com.example.property.management.web.command.TenantUpdate;
import com.example.property.management.web.dto.TenantDto;
import com.itsherman.dto.assembler.utils.DtoTransFormer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TenantApplicationService {

    private final ITenantService tenantService;

    public TenantApplicationService(ITenantService tenantService) {
        this.tenantService = tenantService;
    }


    @Transactional
    public void create(TenantCreate command) {

        if (tenantService.getById(command.getTenantId()) != null) {
            throw ServiceException.of(ErrorCode.ENTITY_REPEAT, CommonConstants.TENANT);
        }

        QueryWrapper<Tenant> wrapper = new QueryWrapper<>();
        wrapper.eq("house_number", command.getHouseNum());
        if (tenantService.getOne(wrapper) != null) {
            throw ServiceException.of(ErrorCode.TENANT_REPEAT_WITH_HOUSE);
        }
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(command, tenant);
        tenantService.save(tenant);
    }

    @Transactional(readOnly = true)
    public TenantDto detail(String tenantId) {
        Tenant tenant = tenantService.getById(tenantId);
        if (tenant == null) {
            throw ServiceException.of(ErrorCode.RESOURCE_NOT_FOUND, CommonConstants.TENANT);
        }
        return DtoTransFormer.to(TenantDto.class).apply(tenant);
    }

    @Transactional(readOnly = true)
    public Page<TenantDto> list(KeywordSearchCommand command, Page<Tenant> pageable) {
        String keyword = command.getKeyword();
        QueryWrapper<Tenant> wrapper = new QueryWrapper<>();
        if (keyword != null) {
            wrapper.like("tenant_name", keyword)
                    .like("tenant_phone", keyword)
                    .like("talent_id", keyword)
                    .like("owner_name", keyword)
                    .like("house_num", keyword);
        }
        Page<Tenant> tenantPage = tenantService.page(pageable, wrapper);
        return MyDtoTransformer.toPage(TenantDto.class).apply(tenantPage);
    }

    @Transactional
    public void delete(String tenantId) {
        tenantService.removeById(tenantId);
    }

    @Transactional
    public void update(TenantUpdate command) {
        Tenant tenant = tenantService.getById(command.getTenantId());
        if (tenant == null) {
            throw ServiceException.of(ErrorCode.RESOURCE_NOT_FOUND, CommonConstants.TENANT);
        }
        QueryWrapper<Tenant> wrapper = new QueryWrapper<>();
        wrapper.eq("house_num", command.getHouseNum());
        if (!tenant.getHouseNum().equals(command.getHouseNum())) {
            Tenant tenant1 = tenantService.getOne(wrapper);
            if (tenant1 != null && !tenant1.getTenantId().equals(tenant.getHouseNum())) {
                throw ServiceException.of(ErrorCode.TENANT_REPEAT_WITH_HOUSE);
            }
        }
        BeanUtils.copyProperties(command, tenant);
        tenantService.saveOrUpdate(tenant);
    }
}
