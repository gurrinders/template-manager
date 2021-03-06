package com.bns.enp.template.manager.controller;

import com.bns.enp.template.manager.exception.ResourceNotFoundException;
import com.bns.enp.template.manager.model.TemplateModel;
import com.bns.enp.template.manager.repository.TemplateManagerRepository;
import com.bns.enp.template.manager.service.TemplateManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TemplateManagerController {

    private TemplateManagerRepository templateRepository;

    @GetMapping("/template/search")
    public @ResponseBody TemplateModel getTemplateById(@RequestBody String templateId) throws ResourceNotFoundException  {
        return templateRepository.findById(templateId).orElseThrow( () -> new ResourceNotFoundException("Template not found: " + templateId));
    }

    @PostMapping("/template")
    public TemplateModel createTemplate(@Valid @RequestBody TemplateModel templateModelBody){
        return templateRepository.save(templateModelBody);
    }

    @PutMapping("/template/{id}")
    public ResponseEntity<TemplateModel> updateTemplate(@PathVariable(value="id") String templateId, @Valid @RequestBody String templateModelBody) throws ResourceNotFoundException {
        TemplateModel templateModel = templateRepository.findById(templateId).orElseThrow(() -> new ResourceNotFoundException("Template not found: " + templateId));;

        templateModel.setTemplateId(templateId);
        templateModel.setData(templateModelBody);
        final TemplateModel updatedTemplate =  templateRepository.save(templateModel);
        return ResponseEntity.ok(updatedTemplate);
    }

    @DeleteMapping("/template/{id}")
    public Map<String,Boolean > deleteCustomer(@PathVariable(value="id") String templateId) throws ResourceNotFoundException {
        TemplateModel customer = templateRepository.findById(templateId).orElseThrow(() -> new ResourceNotFoundException("Template not found: " + templateId));;
        templateRepository.delete(customer);

        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
