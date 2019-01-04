package com.spring.boot.demo.flow;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AlertFlowRepository extends JpaRepository<AlertFlowEntity, String>, JpaSpecificationExecutor<AlertFlowEntity> {

    @Modifying
    @Query("update AlertFlowEntity a set a.isCheck=:isCheck where a.id=:id")
    void update(@Param("id") String id, @Param("isCheck") int isCheck);


}
