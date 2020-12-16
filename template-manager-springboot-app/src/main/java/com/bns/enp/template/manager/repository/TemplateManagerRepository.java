package com.bns.enp.template.manager.repository;

import com.bns.enp.template.manager.model.TemplateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateManagerRepository extends JpaRepository<TemplateModel, String> {

}

