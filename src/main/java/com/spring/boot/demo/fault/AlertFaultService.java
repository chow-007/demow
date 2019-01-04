package com.spring.boot.demo.fault;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertFaultService {

    @Autowired
    private AlertFaultRepository alertFaultRepository;

    public AlertFaultEntity getById(String id) {
        return alertFaultRepository.getOne(id);
    }

    @Transactional
    public void insert(AlertFaultEntity entity){
        alertFaultRepository.save(entity);
    }

    @Transactional
    public void update(AlertFaultEntity entity){
        alertFaultRepository.save(entity);
    }

    @Transactional
    public void delete(String id){
        alertFaultRepository.deleteById(id);
    }

}
