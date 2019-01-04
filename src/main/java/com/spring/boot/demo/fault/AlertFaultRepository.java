package com.spring.boot.demo.fault;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertFaultRepository extends JpaRepository<AlertFaultEntity, String> {
}