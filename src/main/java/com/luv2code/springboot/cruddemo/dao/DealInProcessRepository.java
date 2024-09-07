package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.DealInProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealInProcessRepository extends JpaRepository<DealInProcess, Long> {
}

