package com.spring.boot.demo.fault;

import com.spring.boot.demo.ResultCode;
import com.spring.boot.demo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/alert/fault")
public class AlertFaultController {

    @Autowired
    private AlertFaultService alertFaultService;


    @RequestMapping(value = "/{id}")
    public AlertFaultEntity getAlerFaultEntity(@PathVariable(name = "id") String id){
        return alertFaultService.getById(id);
    }

    @PostMapping
    public ResultEntity create(@RequestBody AlertFaultEntity entity){
        try{
            alertFaultService.insert(entity);
            return new ResultEntity(ResultCode.SUCCESS);
        }catch (Exception e){
            return new ResultEntity(ResultCode.UNKNOW_ERROR, e.toString());
        }
    }

    @PutMapping
    public ResultEntity<Integer> update(@RequestBody AlertFaultEntity entity){
        alertFaultService.update(entity);
        return new ResultEntity<>(ResultCode.SUCCESS);
    }

    @DeleteMapping(value = "/{id}")
    public ResultEntity<Integer> delete(@PathVariable(name = "id") String id){
        alertFaultService.delete(id);
        return new ResultEntity<>(ResultCode.SUCCESS);
    }
}

