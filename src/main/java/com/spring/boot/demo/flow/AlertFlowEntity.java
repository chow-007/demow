package com.spring.boot.demo.flow;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: zhou
 * @Date: 2018-12-29 11:44
 * @Description: 预警信息表
 */
@Entity
@Table(name = "alert_flow")
public class AlertFlowEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    /**
     * 业务模型id
     */
    private String busMid;

    /**
     * 业务topo id
     */
    private String busUid;

    /**
     * 业务名称(所属皮带)
     */
    private String busName;

    /**
     * 设备模型id
     */
    private String devMid;
    /**
     * 设备topo id
     */
    private String devUid;

    /**
     * 设备名称
     */
    private String devName;

    /**
     * 预警信息类型(故障名称)
     */
    private String faultName;

    /**
     * 故障id
     */
    private String faultId;

    /**
     * 异常问题
     */
    private String description;

    /**
     * 解决方式(指导书)
     */
    private String instructionId;

    /**
     * 记录人
     */
    private String recorder;

    /**
     * 预警处理状态
     * 0:未处理
     * 1:已处理
     * 2:处理中
     */
    private Integer isCheck;

    /**
     * 处理时间
     */
    private Date checkTime;

    /**
     * 告警id
     */
    private String uid;
    /**
     * 告警级别
     */
    private Integer level;
    /**
     * 告警时间
     */
    private Date time;


    public AlertFlowEntity(String busMid, String busUid, String busName, String devMid, String devUid, String devName,
                           String instructionId, String description, String uid, Integer level, Date time,
                           String faultId, String faultName, String recorder, Integer isCheck, Date checkTime){
        this.busMid = busMid;
        this.busUid = busUid;
        this.busName = busName;
        this.devMid = devMid;
        this.devUid = devUid;
        this.devName = devName;
        this.instructionId = instructionId;
        this.description = description;
        this.uid = uid;
        this.level = level;
        this.time = time;
        this.faultId = faultId;
        this.faultName = faultName;
        this.recorder = recorder;
        this.isCheck = isCheck;
        this.checkTime = checkTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusMid() {
        return busMid;
    }

    public void setBusMid(String busMid) {
        this.busMid = busMid;
    }

    public String getBusUid() {
        return busUid;
    }

    public void setBusUid(String busUid) {
        this.busUid = busUid;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getDevMid() {
        return devMid;
    }

    public void setDevMid(String devMid) {
        this.devMid = devMid;
    }

    public String getDevUid() {
        return devUid;
    }

    public void setDevUid(String devUid) {
        this.devUid = devUid;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getFaultId() {
        return faultId;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
