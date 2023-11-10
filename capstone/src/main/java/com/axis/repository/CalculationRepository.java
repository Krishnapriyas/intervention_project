package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.model.Budget;

public interface CalculationRepository extends JpaRepository<Budget, Long> {

}
