package com.axis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.BudgetDTO;
import com.axis.dto.ExpenseDTO;
import com.axis.model.Budget;
import com.axis.model.User;
import com.axis.repository.BudgetRepository;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;


    @Autowired
    private UserService userService; 
    
	/*
	 * public Budget createBudget(Long userId,Budget budget) { User user =
	 * userService.getUserById(userId); if (user == null) { user = new User();
	 * user.setUserName("newUser"); user.setPassword("newPassword");
	 * userService.createUser(user); } budget.setUser(user); return
	 * budgetRepository.save(budget); }
	 */

    public Budget getBudgetById(Long budgetId) {
        return budgetRepository.findById(budgetId).orElse(null);
    }

    public List<BudgetDTO> getAllBudgets() {
        List<Budget> budgets = budgetRepository.findAll();
        List<BudgetDTO> budgetDTOs = new ArrayList<>();

        for (Budget budget : budgets) {
            BudgetDTO budgetDTO = new BudgetDTO();
            budgetDTO.setBudgetId(budget.getBudgetId());
            budgetDTO.setBudgetCategory(budget.getBudgetCategory());
            budgetDTO.setAllocatedAmount(budget.getAllocatedAmount());
            budgetDTOs.add(budgetDTO);
        }
        return budgetDTOs;

    }

    public Budget updateBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void deleteBudget(Long budgetId) {
        budgetRepository.deleteById(budgetId);
    }
    
    public Budget createBudget1(BudgetDTO budgetdto) {
		Budget budget = new Budget();
		budget.setBudgetCategory(budgetdto.getBudgetCategory());
		budget.setAllocatedAmount(budgetdto.getAllocatedAmount());
		budget.setExpenses(budget.getExpenses());
		return budgetRepository.save(budget);


    }

	public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);

	}
}
