package com.axis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.BudgetDTO;
import com.axis.dto.ExpenseDTO;
import com.axis.model.Expense;
import com.axis.repository.ExpenseRepository;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense getExpenseById(Long expenseId) {
        return expenseRepository.findById(expenseId).orElse(null);
    }

    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenses= expenseRepository.findAll();
        List<ExpenseDTO> expenseDTOs = new ArrayList<>();

        for (Expense expense : expenses) {
            ExpenseDTO expenseDTO = new ExpenseDTO();
            expenseDTO.setExpenseId(expense.getExpenseId());
            expenseDTO.setExpenseCategory(expense.getExpenseCategory());
            expenseDTO.setDate(expense.getDate());
            expenseDTO.setAmount(expense.getAmount());
            expenseDTO.setDescription(expense.getDescription());
            expenseDTOs.add(expenseDTO);        }
    return expenseDTOs;
    }

    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }
}
