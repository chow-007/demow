package com.spring.boot.demo.instruction;


import com.spring.boot.demo.ResultCode;
import com.spring.boot.demo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alert/instruction")
public class AlertInstructionController {

    @Autowired
    private AlertInstructionsService alertInstructionsService;


    @RequestMapping(value = "/{id}")
    public AlertInstructionsEntity getById(@PathVariable(name = "id") String id){
        return alertInstructionsService.getById(id);
    }

    @PostMapping
    public ResultEntity<Integer> insert(AlertInstructionsEntity entity){
        alertInstructionsService.add(entity);
        return new ResultEntity<>(ResultCode.SUCCESS);
    }

}
