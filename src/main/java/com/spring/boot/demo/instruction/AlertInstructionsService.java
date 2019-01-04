package com.spring.boot.demo.instruction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertInstructionsService {

    @Autowired
    private AlertInstructionsRepository alertInstructionsRepository;

    public AlertInstructionsEntity getById(String id){
        return alertInstructionsRepository.getOne(id);
    }

    @Transactional
    public void add(AlertInstructionsEntity entity){
        alertInstructionsRepository.save(entity);
    }
}
