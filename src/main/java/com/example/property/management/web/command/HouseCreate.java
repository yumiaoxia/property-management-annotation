package com.example.property.management.web.command;




import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class HouseCreate {

    /**
     * 房号
     */
    @Size(max = 4)
    @NotBlank
    private String houseNum;

    /**
     * 房间的入住状态
     */
    @Size(max = 2)
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
