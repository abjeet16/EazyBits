package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.ProposedDeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposedDealRepository extends JpaRepository<ProposedDeal, Long> {
}
