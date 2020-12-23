package com.bns.enp.template.manager.service;

import com.bns.enp.template.manager.exception.ResourceNotFoundException;
import com.bns.enp.template.manager.model.TemplateModel;
import com.bns.enp.template.manager.repository.TemplateManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateManagerService {

    private TemplateModel template;

    @Autowired
    private TemplateManagerRepository templateRepository;

    public TemplateModel getTemplateById(String templateId) throws ResourceNotFoundException {

        TemplateModel specificTemplate =  templateRepository.findById(templateId).orElseThrow( () -> new ResourceNotFoundException("Template not found: " + templateId));
        TemplateModel genericTemplate =  templateRepository.findById(specificTemplate.getGenericTemplate()).orElseThrow( () -> new ResourceNotFoundException("Template not found: " + templateId));

        return specificTemplate;
    }
}
