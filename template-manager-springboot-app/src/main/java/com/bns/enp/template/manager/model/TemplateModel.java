package com.bns.enp.template.manager.model;

import javax.persistence.*;

@Entity
@Table(name="TemplateModel")
public class TemplateModel {

    @Id
    @Column(name="template_id", nullable = false)
    private String templateId;

    @Column(name="template_content", nullable = false)
    private String content;

    @Column(name="template_generic_id")
    private String genericTemplate;

    @Column(name="template_update_timestamp", nullable = false)
    private String timeStamp;

    public TemplateModel() {
    }

    public TemplateModel(String templateId, String content, String genericTemplate, String timeStamp) {
        this.templateId = templateId;
        this.content = content;
        this.genericTemplate = genericTemplate;
        this.timeStamp = timeStamp;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGenericTemplate() {
        return genericTemplate;
    }

    public void setGenericTemplate(String genericTemplate) {
        this.genericTemplate = genericTemplate;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
