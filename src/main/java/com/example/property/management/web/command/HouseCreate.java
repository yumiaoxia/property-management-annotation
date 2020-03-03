package com.example.property.management.web.command;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class HouseCreate {

    /**
     * 房号
     */
    @Length(max = 4)
    @NotBlank
    private String houseNum;

    /**
     * 房间的入住状态
     */
    @Length(max = 2)
    private String houseState;

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getHouseState() {
        return houseState;
    }

    public void setHouseState(String houseState) {
        this.houseState = houseState;
    }
}
