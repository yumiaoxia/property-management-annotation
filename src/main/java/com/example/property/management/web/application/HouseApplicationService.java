package com.example.property.management.web.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.constants.CommonConstants;
import com.example.property.management.entity.House;
import com.example.property.management.exception.ErrorCode;
import com.example.property.management.exception.ServiceException;
import com.example.property.management.service.IHouseService;
import com.example.property.management.utils.MyDtoTransformer;
import com.example.property.management.web.command.HouseCreate;
import com.example.property.management.web.command.HouseUpdate;
import com.example.property.management.web.dto.HouseDto;
import com.itsherman.dto.assembler.utils.DtoTransFormer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class HouseApplicationService {

    private final IHouseService houseService;

    public HouseApplicationService(IHouseService houseService) {
        this.houseService = houseService;
    }

    @Transactional
    public void create(HouseCreate command) {
        QueryWrapper<House> wrapper = new QueryWrapper<>();
        wrapper.eq("house_num", command.getHouseNum());
        if (houseService.count(wrapper) > 0) {
            throw ServiceException.of(ErrorCode.ENTITY_REPEAT, CommonConstants.HOUSE);
        }
        House house = new House();
        BeanUtils.copyProperties(command, house);
        houseService.save(house);
    }

    @Transactional(readOnly = true)
    public HouseDto detail(String houseNum) {
        House house = houseService.getById(houseNum);
        return DtoTransFormer.to(HouseDto.class).apply(house);
    }

    @Transactional(readOnly = true)
    public Page<HouseDto> list(Page<House> pageable) {
        Page<House> housePage = houseService.page(pageable);
        return MyDtoTransformer.toPage(HouseDto.class).apply(housePage);
    }

    @Transactional
    public void delete(String houseNum) {
        houseService.removeById(houseNum);
    }

    @Transactional
    public void update(HouseUpdate command) {
        House house = houseService.getById(command.getHouseNum());
        house.setHouseState(command.getHouseState());
        houseService.saveOrUpdate(house);
    }
}
