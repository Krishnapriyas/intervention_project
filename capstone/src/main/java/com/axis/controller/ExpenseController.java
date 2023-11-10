package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.ExpenseDTO;
import com.axis.model.Expense;
import com.axis.service.ExpenseService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;

	@PostMapping("/createExpense")
	public Expense createExpense(@RequestBody Expense expense) {
		return expenseService.createExpense(expense);
	}

	@GetMapping("getExpense/{expenseId}")
	public Expense getExpense(@PathVariable Long expenseId) {
		return expenseService.getExpenseById(expenseId);
	}
	
	@GetMapping("/getAllExpenses")
	public List<ExpenseDTO> getAllBugets() {
		return expenseService.getAllExpenses();
	}

	/*
	 * @GetMapping("/user/{userId}") public List<Expense>
	 * getUserExpenses(@PathVariable Long userId) { return
	 * expenseService.getAllExpensesByUser(userId); }
	 */

	@PutMapping("updateExpense/{expenseId}")
	public Expense updateExpense(@PathVariable Long expenseId, @RequestBody Expense expense) {
		expense.setExpenseId(expenseId);
		return expenseService.updateExpense(expense);
	}

	@DeleteMapping("deleteExpense/{expenseId}")
	public void deleteExpense(@PathVariable Long expenseId) {
		expenseService.deleteExpense(expenseId);
	}
}
