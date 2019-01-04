package com.spring.boot.demo.flow;


import com.spring.boot.demo.PageQuery;
import com.spring.boot.demo.ResultCode;
import com.spring.boot.demo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/alert")
public class AlertFlowController {


    @Autowired
    private AlertFlowService alertFlowService;


    /**
     * 获取预警信息列表
     * @return
     */
//    @RequestMapping
//    public List<AlertFlowEntity> alertFlowEntities(PageQuery pageQuery){
//        System.out.println(pageQuery.getPageNum());
//        List<AlertFlowEntity> res = alertFlowService.getAlertFlowEntities(pageQuery);
//        return res;
//    }

    @RequestMapping
    public PageImpl<AlertFlowEntity> alertFlowEntities(AlertFlowQuery alertFlowQuery){
        PageImpl<AlertFlowEntity> res = alertFlowService.get(alertFlowQuery);

        return res;
    }

    @PostMapping
    public ResultEntity create(@RequestBody AlertFlowEntity entity){
        try{
            alertFlowService.insert(entity);
            return new ResultEntity(ResultCode.SUCCESS);
        }catch (Exception e){
            return new ResultEntity(ResultCode.UNKNOW_ERROR, e.toString());
        }
    }


    /**
     * 根据id更新预警信息的状态（status -> 0：未处理，1：已处理，2：处理中）
     * @param id
     * @param map
     */
    @PutMapping(value = "/{id}")
    public ResultEntity<Integer> alertFlowEntitiesUpdate(@PathVariable(name = "id") String id, @RequestBody Map<String, Integer> map){
        int status = map.get("status");
        alertFlowService.updateAlertFlow(id,status);
        return new ResultEntity<>(ResultCode.SUCCESS);
    }

}
