package com.axis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long calculationId;
	private String calculationType;
	private double amount;
	private double interestRate;
	private int tenureInMonths;
	private int NoCompoundedInterest;
	private double actualSpending;
	private double budgetedAmount;
	private double totalExpensesInCategory;
	private double totalExpenses;
	private double totalIncome;

	public double getActualSpending() {
		return actualSpending;
	}

	public void setActualSpending(double actualSpending) {
		this.actualSpending = actualSpending;
	}

	public double getBudgetedAmount() {
		return budgetedAmount;
	}

	public void setBudgetedAmount(double budgetedAmount) {
		this.budgetedAmount = budgetedAmount;
	}

	public double getTotalExpensesInCategory() {
		return totalExpensesInCategory;
	}

	public void setTotalExpensesInCategory(double totalExpensesInCategory) {
		this.totalExpensesInCategory = totalExpensesInCategory;
	}

	public double getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(double totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public Long getCalculationId() {
		return calculationId;
	}

	public void setCalculationId(Long calculationId) {
		this.calculationId = calculationId;
	}

	public String getCalculationType() {
		return calculationType;
	}

	public void setCalculationType(String calculationType) {
		this.calculationType = calculationType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getTenureInMonths() {
		return tenureInMonths;
	}

	public void setTenureInMonths(int tenureInMonths) {
		this.tenureInMonths = tenureInMonths;
	}

	public int getNoCompoundedInterest() {
		return NoCompoundedInterest;
	}

	public void setNoCompoundedInterest(int noCompoundedInterest) {
		NoCompoundedInterest = noCompoundedInterest;
	}

	public Calculation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calculation(Long calculationId, String calculationType, double amount, double interestRate,
			int tenureInMonths, int noCompoundedInterest) {
		super();
		this.calculationId = calculationId;
		this.calculationType = calculationType;
		this.amount = amount;
		this.interestRate = interestRate;
		this.tenureInMonths = tenureInMonths;
		NoCompoundedInterest = noCompoundedInterest;
	}

	public Calculation(Long calculationId, String calculationType, double amount, double interestRate,
			int tenureInMonths, int noCompoundedInterest, double actualSpending, double budgetedAmount,
			double totalExpensesInCategory, double totalExpenses, double totalIncome) {
		super();
		this.calculationId = calculationId;
		this.calculationType = calculationType;
		this.amount = amount;
		this.interestRate = interestRate;
		this.tenureInMonths = tenureInMonths;
		NoCompoundedInterest = noCompoundedInterest;
		this.actualSpending = actualSpending;
		this.budgetedAmount = budgetedAmount;
		this.totalExpensesInCategory = totalExpensesInCategory;
		this.totalExpenses = totalExpenses;
		this.totalIncome = totalIncome;
	}

	@Override
	public String toString() {
		return "Calculation [calculationId=" + calculationId + ", calculationType=" + calculationType + ", amount="
				+ amount + ", interestRate=" + interestRate + ", tenureInMonths=" + tenureInMonths
				+ ", NoCompoundedInterest=" + NoCompoundedInterest + ", actualSpending=" + actualSpending
				+ ", budgetedAmount=" + budgetedAmount + ", totalExpensesInCategory=" + totalExpensesInCategory
				+ ", totalExpenses=" + totalExpenses + ", totalIncome=" + totalIncome + "]";
	}

}
