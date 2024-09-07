package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.ContactedDeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactedDealRepository extends JpaRepository<ContactedDeal, Long> {
}
