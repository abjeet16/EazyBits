package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.NegotiationDeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NegotiationDealRepository extends JpaRepository<NegotiationDeal, Long> {
}
