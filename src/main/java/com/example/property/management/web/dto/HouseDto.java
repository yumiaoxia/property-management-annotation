package com.example.property.management.web.dto;

import com.example.property.management.entity.House;
import com.itsherman.dto.assembler.annotations.DtoModel;

@DtoModel(from = House.class)
public interface HouseDto {

    String getHouseNum();

    String getHouseState();
}
