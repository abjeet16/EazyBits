package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.ClosedDeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClosedDealRepository extends JpaRepository<ClosedDeal, Long> {
}
