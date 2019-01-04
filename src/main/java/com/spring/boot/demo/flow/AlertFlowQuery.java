package com.spring.boot.demo.flow;


import com.spring.boot.demo.PageQuery;

public class AlertFlowQuery extends PageQuery {

    private Integer isCheck;

    private Integer level;

    private String faultId;

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getFaultId() {
        return faultId;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }
}
