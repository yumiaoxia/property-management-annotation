package com.example.property.management.web.command;

import javax.validation.constraints.NotBlank;

public class OrderDetail extends KeywordSearchCommand {

    @NotBlank
    private String houseNum;

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }
}
