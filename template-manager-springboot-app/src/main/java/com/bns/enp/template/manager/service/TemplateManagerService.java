package com.bns.enp.template.manager.service;

import com.bns.enp.template.manager.model.TemplateModel;
import org.springframework.stereotype.Service;

@Service
public class TemplateManagerService {

    private TemplateModel template;

    public TemplateModel getTemplateById(String id) {
        return new TemplateModel();
    }
}
