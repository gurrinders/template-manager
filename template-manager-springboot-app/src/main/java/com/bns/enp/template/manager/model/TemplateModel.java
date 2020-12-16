package com.bns.enp.template.manager.model;

import javax.persistence.*;

@Entity
@Table(name="TemplateModel")
public class TemplateModel {

    @Id
    @Column(name="templateId", nullable = false)
    private String templateId;

    @Column(name="data", nullable = false)
    private String data;

    public TemplateModel() {
    }

    public TemplateModel(String templateId, String data) {
        this.templateId = templateId;
        this.data = data;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TemplateModel{" +
                "templateId='" + templateId + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
