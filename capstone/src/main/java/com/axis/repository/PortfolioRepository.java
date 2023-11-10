package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.model.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
