package com.example.property.management.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 职工表
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@TableName("worker")
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物业职工的工号
     */
    @TableId("worker_id")
    private String workerId;

    /**
     * 物业职工的姓名
     */
    @TableField("worker_name")
    private String workerName;

    /**
     * 物业职工的性别
     */
    @TableField("worker_sex")
    private String workerSex;

    /**
     * 物业职工的电话号码
     */
    @TableField("worker_phone")
    private String workerPhone;

    /**
     * 物业职工的职称
     */
    @TableField("position")
    private String position;

    /**
     * 物业职工的身份证号
     */
    @TableField("identity")
    private String identity;


    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerSex() {
        return workerSex;
    }

    public void setWorkerSex(String workerSex) {
        this.workerSex = workerSex;
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerId=" + workerId +
                ", workerName=" + workerName +
                ", workerSex=" + workerSex +
                ", workerPhone=" + workerPhone +
                ", position=" + position +
                ", identity=" + identity +
                "}";
    }
}
