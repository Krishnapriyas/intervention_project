package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.BudgetDTO;
import com.axis.model.Budget;
import com.axis.service.BudgetService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/budgets")
public class BudgetController {
	@Autowired
	private BudgetService budgetService;

	/*
	 * @PostMapping("/createBudget/{userId}") public ResponseEntity<BudgetDTO>
	 * createBudget(@RequestBody BudgetDTO budgetDTO,
	 * 
	 * @RequestParam("userId") Long userId) { try { System.out.println(userId);
	 * Budget budget = new Budget();
	 * budget.setBudgetCategory(budgetDTO.getBudgetCategory());
	 * budget.setAllocatedAmount(budgetDTO.getAllocatedAmount());
	 * 
	 * Budget createdBudget = budgetService.createBudget(userId, budget);
	 * 
	 * BudgetDTO createdBudgetDTO = new BudgetDTO();
	 * createdBudgetDTO.setBudgetId(createdBudget.getBudgetId());
	 * createdBudgetDTO.setBudgetCategory(createdBudget.getBudgetCategory());
	 * createdBudgetDTO.setAllocatedAmount(createdBudget.getAllocatedAmount());
	 * 
	 * return new ResponseEntity<>(createdBudgetDTO, HttpStatus.CREATED); } catch
	 * (Exception e) { return new ResponseEntity<>(null,
	 * HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	
	 @PostMapping("/createBudgets") 
	 public Budget createBudgetC(@RequestBody Budget budget) 
	 { return budgetService.createBudget(budget); }
	 
	 @PostMapping("/createBudget") 
	 public Budget createBudget1(@RequestBody BudgetDTO budgetdto) 
	 { return budgetService.createBudget1(budgetdto); }

	@GetMapping("/getBudget/{budgetId}")
	public Budget getBudget(@PathVariable Long budgetId) {
		return budgetService.getBudgetById(budgetId);
	}

	@GetMapping("/getAllBudgets")
	public List<BudgetDTO> getAllBugets() {
		return budgetService.getAllBudgets();
	}
	/*
	 * @GetMapping("/user/{userId}") public List<Budget>
	 * getUserBudgets(@PathVariable Long userId) { return
	 * budgetService.getAllBudgetsByUser(userId); }
	 */

	@PutMapping("/updateBudget/{budgetId}")
	public Budget updateBudget(@PathVariable Long budgetId, @RequestBody Budget budget) {
		budget.setBudgetId(budgetId);
		return budgetService.updateBudget(budget);
	}

	@DeleteMapping("/deleteBudget/{budgetId}")
	public void deleteBudget(@PathVariable Long budgetId) {
		budgetService.deleteBudget(budgetId);
	}
}
