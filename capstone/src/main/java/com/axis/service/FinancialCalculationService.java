package com.axis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.model.Calculation;
import com.axis.repository.CalculationRepository;

@Service
public class FinancialCalculationService {

	@Autowired
	private CalculationRepository calculationRepository;

	// EMI = P × r × (1+r)^n / ((1+r)^n - 1)
	/*
	 * public double calculateLoanEMI(double principal, double annualInterestRate,
	 * int tenureInMonths) {
	 * 
	 * double monthlyInterestRate = annualInterestRate / 12 / 100; int
	 * totalInstallments = tenureInMonths; double emi = principal *
	 * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalInstallments) /
	 * (Math.pow(1 + monthlyInterestRate, totalInstallments) - 1); return emi; }
	 */

	public double calculateLoanEMIC(Calculation calculation) {
		double principal = calculation.getAmount();
		double annualInterestRate = calculation.getInterestRate();
		int tenureInMonths = calculation.getTenureInMonths();
		

		double monthlyInterestRate = annualInterestRate / 12 / 100;
		int totalInstallments = tenureInMonths;
		double emi = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalInstallments)
				/ (Math.pow(1 + monthlyInterestRate, totalInstallments) - 1);
		return emi;
	}

	// FV = PV × (1 + r/n)^(n*t)
	/*
	 * public double calculateInvestmentGrowth(double initialInvestment, double
	 * annualInterestRate, int compoundingFrequency, int years) {
	 * 
	 * double annualInterestRateDecimal = annualInterestRate / 100;
	 * 
	 * int n = compoundingFrequency;
	 * 
	 * int totalCompoundingPeriods = n * years;
	 * 
	 * double futureValue = initialInvestment * Math.pow(1 +
	 * annualInterestRateDecimal / n, totalCompoundingPeriods);
	 * 
	 * return futureValue; }
	 */

	public double calculateInvestmentGrowthC(Calculation calculation) {

		double initialInvestment = calculation.getAmount();
		double annualInterestRate = calculation.getInterestRate();
		int compoundingFrequency = calculation.getNoCompoundedInterest();
		int years = calculation.getTenureInMonths()/12;
		System.out.println(initialInvestment+" "+annualInterestRate+" "+compoundingFrequency+ " "+years+" "+calculation.getTenureInMonths());

		double annualInterestRateDecimal = annualInterestRate / 100;

		// int n = compoundingFrequency;

		int totalCompoundingPeriods = compoundingFrequency * years;

		double futureValue = initialInvestment
				* Math.pow(1 + annualInterestRateDecimal / compoundingFrequency, totalCompoundingPeriods);

		return futureValue;

	}

	public double calculateBudgetCategorySpendingPercentage(Calculation calculate) {
		double actualSpending = calculate.getActualSpending();
		double budgetedAmount = calculate.getBudgetedAmount();
		return (actualSpending / budgetedAmount) * 100;
	}

	public double calculateExpenseCategorySpendingPercentage(Calculation calculate) {
		double totalExpensesInCategory = calculate.getTotalExpensesInCategory();
		double totalExpenses = calculate.getTotalExpenses();
		return (totalExpensesInCategory / totalExpenses) * 100;
	}

	public double calculateNetSavings(Calculation calculate) {
		double totalIncome = calculate.getTotalIncome();
		double totalExpenses = calculate.getTotalExpenses();
		return totalIncome - totalExpenses;
	}
}
