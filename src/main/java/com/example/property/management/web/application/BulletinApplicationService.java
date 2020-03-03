package com.example.property.management.web.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.constants.CommonConstants;
import com.example.property.management.entity.Bulletin;
import com.example.property.management.exception.ErrorCode;
import com.example.property.management.exception.ServiceException;
import com.example.property.management.service.IBulletinService;
import com.example.property.management.utils.MyDtoTransformer;
import com.example.property.management.web.command.BulletinCreate;
import com.example.property.management.web.command.BulletinUpdate;
import com.example.property.management.web.dto.BulletinDto;
import com.itsherman.dto.assembler.utils.DtoTransFormer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BulletinApplicationService {

    private final IBulletinService bulletinService;

    public BulletinApplicationService(IBulletinService bulletinService) {
        this.bulletinService = bulletinService;
    }

    @Transactional
    public void create(BulletinCreate command) {
        QueryWrapper<Bulletin> wrapper = new QueryWrapper<>();
        wrapper.eq("bulletin_id", command.getBulletinId());
        if (bulletinService.count(wrapper) > 0) {
            throw ServiceException.of(ErrorCode.ENTITY_REPEAT, CommonConstants.BULLETIN);
        }
        Bulletin bulletin = new Bulletin();
        BeanUtils.copyProperties(command, bulletin);
        bulletinService.save(bulletin);
    }

    @Transactional(readOnly = true)
    public BulletinDto detail(String bulletinId) {
        Bulletin bulletin = bulletinService.getById(bulletinId);
        if (bulletin == null) {
            throw ServiceException.of(ErrorCode.RESOURCE_NOT_FOUND, CommonConstants.BULLETIN);
        }
        return DtoTransFormer.to(BulletinDto.class).apply(bulletin);
    }

    @Transactional(readOnly = true)
    public Page<BulletinDto> list(Page<Bulletin> pageable) {
        Page<Bulletin> bulletinPage = bulletinService.page(pageable);
        return MyDtoTransformer.toPage(BulletinDto.class).apply(bulletinPage);
    }

    @Transactional
    public void update(BulletinUpdate command) {
        Bulletin bulletin = bulletinService.getById(command.getBulletinId());
        if (bulletin == null) {
            throw ServiceException.of(ErrorCode.RESOURCE_NOT_FOUND, CommonConstants.BULLETIN);
        }
        BeanUtils.copyProperties(command, bulletin);
        bulletinService.saveOrUpdate(bulletin);
    }
}
