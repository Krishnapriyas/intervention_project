package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
