package com.example.property.management.web.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.constants.CommonConstants;
import com.example.property.management.entity.Owner;
import com.example.property.management.exception.ErrorCode;
import com.example.property.management.exception.ServiceException;
import com.example.property.management.service.IOwnerService;
import com.example.property.management.utils.MyDtoTransformer;
import com.example.property.management.web.command.KeywordSearchCommand;
import com.example.property.management.web.command.OwnerCreate;
import com.example.property.management.web.command.OwnerUpdate;
import com.example.property.management.web.dto.OwnerDto;
import com.itsherman.dto.assembler.utils.DtoTransFormer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OwnerApplicationService {

    private final IOwnerService ownerService;

    public OwnerApplicationService(IOwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public void create(OwnerCreate command) {
        if (ownerService.getById(command.getHouseNumber()) != null) {
            throw ServiceException.of(ErrorCode.ENTITY_REPEAT, CommonConstants.OWNER);
        }
        Owner owner = new Owner();
        BeanUtils.copyProperties(command, owner);
        ownerService.save(owner);
    }

    @Transactional(readOnly = true)
    public OwnerDto detail(String houseNumber) {
        Owner owner = ownerService.getById(houseNumber);
        if (owner == null) {
            throw ServiceException.of(ErrorCode.RESOURCE_NOT_FOUND, CommonConstants.OWNER);
        }
        return DtoTransFormer.to(OwnerDto.class).apply(owner);
    }

    @Transactional(readOnly = true)
    public Page<OwnerDto> list(KeywordSearchCommand command, Page<Owner> pageable) {
        String keyword = command.getKeyword();
        QueryWrapper<Owner> wrapper = new QueryWrapper<>();
        if (keyword != null) {
            wrapper.like("owner_name", keyword).or().like("owner_phone", keyword).or().like("house_number", keyword);
        }
        Page<Owner> ownerPage = ownerService.page(pageable, wrapper);
        return MyDtoTransformer.toPage(OwnerDto.class).apply(ownerPage);
    }

    @Transactional
    public void delete(String houseNumber) {
        ownerService.removeById(houseNumber);
    }

    @Transactional
    public void update(OwnerUpdate command) {
        Owner owner = ownerService.getById(command.getHouseNumber());
        if (owner == null) {
            throw ServiceException.of(ErrorCode.RESOURCE_NOT_FOUND, CommonConstants.OWNER);
        }
        BeanUtils.copyProperties(command, owner);
        ownerService.saveOrUpdate(owner);
    }
}
