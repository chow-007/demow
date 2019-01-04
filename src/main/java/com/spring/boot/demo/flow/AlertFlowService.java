package com.spring.boot.demo.flow;


import com.spring.boot.demo.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PrePersist;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

@Service
public class AlertFlowService {


    @Autowired
    private AlertFlowRepository alertFlowRepository;

    @PersistenceContext
    private EntityManager entityManager;



    @Transactional
    public void insert(AlertFlowEntity entity){
        alertFlowRepository.save(entity);
    }

//    public List<AlertFlowEntity> getAlertFlowEntities(PageQuery pageQuery){
//        if (pageQuery.getPageSize() == 0){
//            pageQuery.setPageSize(10);
//        }
//
//        List<AlertFlowEntity> alertFlowEntities = alertFlowRepository.findAll(new PageRequest(pageQuery.getPageNum(), pageQuery.getPageSize())).getContent();
//        return alertFlowEntities;
//    }

    public PageImpl<AlertFlowEntity> get(AlertFlowQuery alertFlowQuery){
        Sort sort = new Sort(Sort.Direction.DESC, "time"); //创建时间降序排序
        Pageable pageRequest = PageRequest.of(1, 10);

        StringBuilder datasql = new StringBuilder("select * from alert_flow a");
        StringBuilder countSql = new StringBuilder("SELECT count(1) FROM alert_flow a ");

        StringBuilder whereSql = new StringBuilder(" where 1=1");
        if (alertFlowQuery.getIsCheck() != null){
            whereSql.append( " and a.is_check=:isCheck");
        }
        if (alertFlowQuery.getFaultId() != null){
            whereSql.append(" and a.fault_id=:faultId");
        }
        if (alertFlowQuery.getLevel() != null){
            whereSql.append(" and a.level=:level");
        }
        if (alertFlowQuery.getStartTime() != null && alertFlowQuery.getEndTime() != null){
            whereSql.append(" and a.time >= :startTime and a.time <= :endTime");
        }

//        datasql.append(whereSql).append(" order by a.time desc limit :pageNum,:pageSize");
//        datasql.append(whereSql).append(" order by a.time desc limit 0,1");
        countSql.append(whereSql);

        System.out.println(datasql.toString());
        Query dataQuery = entityManager.createNativeQuery(datasql.toString(), AlertFlowEntity.class);
        Query countQuery = entityManager.createNativeQuery(countSql.toString());

        if (alertFlowQuery.getIsCheck() != null){
            dataQuery.setParameter("isCheck", alertFlowQuery.getIsCheck());
            countQuery.setParameter("isCheck", alertFlowQuery.getIsCheck());
        }
        if (alertFlowQuery.getFaultId() != null){
            dataQuery.setParameter("faultId", alertFlowQuery.getFaultId());
            countQuery.setParameter("faultId", alertFlowQuery.getFaultId());
        }
        if (alertFlowQuery.getLevel() != null){
            dataQuery.setParameter("level", alertFlowQuery.getLevel());
            countQuery.setParameter("level", alertFlowQuery.getLevel());
        }
        if (alertFlowQuery.getStartTime() != null && alertFlowQuery.getEndTime() != null){
            dataQuery.setParameter("startTime", alertFlowQuery.getStartTime());
            dataQuery.setParameter("endTime", alertFlowQuery.getEndTime());
            countQuery.setParameter("startTime", alertFlowQuery.getStartTime());
            countQuery.setParameter("endTime", alertFlowQuery.getEndTime());
        }
//        dataQuery.setParameter("pageNum", alertFlowQuery.getPageNum());
//        dataQuery.setParameter("pageSize", alertFlowQuery.getPageSize());


//        dataQuery.setFirstResult(pageRequest.getPageNumber());
//        dataQuery.setMaxResults(pageRequest.getPageSize());
        BigInteger count = (BigInteger) countQuery.getSingleResult();
        Long total = count.longValue();
        List<AlertFlowEntity> alertFlowEntities = total > pageRequest.getOffset() ? dataQuery.getResultList() : Collections.<AlertFlowEntity> emptyList();
        return new PageImpl<>(alertFlowEntities, pageRequest, total);

    }


    @Transactional
    public void updateAlertFlow(String id, int status){
        alertFlowRepository.update(id, status);
    }

}
