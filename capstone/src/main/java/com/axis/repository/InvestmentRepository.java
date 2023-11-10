package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.model.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
}
