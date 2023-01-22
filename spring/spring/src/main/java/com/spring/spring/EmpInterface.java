package com.spring.spring;

import org.springframework.data.jpa.repository.JpaRepository;
public interface EmpInterface extends JpaRepository <Emp, Integer> {
}

