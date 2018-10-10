package com.mybatis.po;

import java.util.Date;

/**
 * Created by xlf on 2018/10/10.
 */
public class Account {

    private Integer id;
    private String aname;
    private String type;
    private Double money;
    private Integer user_id;
    private Date createTime;
    private Date updateTime;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", aname='" + aname + '\'' +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", user_id=" + user_id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
