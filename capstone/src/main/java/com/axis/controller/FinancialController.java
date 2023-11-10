package com.axis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Calculation;
import com.axis.service.FinancialCalculationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/financial")
public class FinancialController {
	@Autowired
	private FinancialCalculationService financialService;
	@Autowired
	private ObjectMapper objectMapper;

	/*
	 * @GetMapping(
	 * "/calculateLoanEMI/{principal}/{annualInterestRate}/{tenureInMonths}") public
	 * double calculateLoanEMI(@RequestParam double principal, @RequestParam double
	 * annualInterestRate,
	 * 
	 * @RequestParam int tenureInMonths) { return
	 * financialService.calculateLoanEMI(principal, annualInterestRate,
	 * tenureInMonths); }
	 */

	@PostMapping("/calculateLoanEMI")
	public double calculateLoanEMIC(@RequestBody Calculation calculation) {
	    double principal = calculation.getAmount();
	    double annualInterestRate = calculation.getInterestRate();
	    int tenureInMonths = calculation.getTenureInMonths();
	    System.out.println("Principal: " + principal);
	    System.out.println("Annual Interest Rate: " + annualInterestRate);
	    System.out.println("Tenure In Months: " + tenureInMonths);
		return financialService.calculateLoanEMIC(calculation);
	}

	/*
	 * @GetMapping(
	 * "/calculateInvestmentGrowth/{initialInvestment}/{annualInterestRate}/{compoundingFrequency}/{years}")
	 * public double calculateInvestmentGrowth(@RequestParam double
	 * initialInvestment,
	 * 
	 * @RequestParam double annualInterestRate, @RequestParam int
	 * compoundingFrequency, @RequestParam int years) { return
	 * financialService.calculateInvestmentGrowth(initialInvestment,
	 * annualInterestRate, compoundingFrequency, years); }
	 */
	@PostMapping("/calculateInvestmentGrowth")
	public ResponseEntity<String> calculateInvestmentGrowth(@RequestBody String jsonInput) {
		try {
			Calculation calculation = objectMapper.readValue(jsonInput, Calculation.class);
			double futureValue = financialService.calculateInvestmentGrowthC(calculation);

			String result = "Future Value: " + futureValue;

			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/budgetCategorySpendingPercentage")
	public ResponseEntity<Double> calculateBudgetCategorySpendingPercentage(@RequestBody Calculation calculation) {
		double percentage = financialService.calculateBudgetCategorySpendingPercentage(calculation);
		return ResponseEntity.ok(percentage);
	}

	@PostMapping("/expenseCategorySpendingPercentage")
	public ResponseEntity<Double> calculateExpenseCategorySpendingPercentage(@RequestBody Calculation calculation) {
		double percentage = financialService.calculateExpenseCategorySpendingPercentage(calculation);
		return ResponseEntity.ok(percentage);
	}

	@PostMapping("/netSavings")
	public ResponseEntity<Double> calculateNetSavings(@RequestBody Calculation calculation) {
		double netSavings = financialService.calculateNetSavings(calculation);
		return ResponseEntity.ok(netSavings);
	}

}
