package com.example.property.management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 楼盘信息表
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@TableName("house")
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房号
     */
    @TableId("house_num")
    private String houseNum;

    /**
     * 房间的入住状态
     */
    @TableField("house_state")
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

    @Override
    public String toString() {
        return "House{" +
                "houseNum=" + houseNum +
                ", houseState=" + houseState +
                "}";
    }
}
