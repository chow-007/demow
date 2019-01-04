package com.spring.boot.demo.instruction;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alert_instructions")
public class AlertInstructionsEntity {

    /**
     * 检修指导书id
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    /**
     * 检修指导书名称
     */
    private String faultName;

    /**
     *检修指导书内容
     */
    @Column(columnDefinition = "TEXT")
    private String content;

    /**
     *检修指导书作者
     */
    private String author;

    /**
     * 创建时间
     */
    private Date time;

    /**
     * 检修指导书版本
     */
    private String version;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

