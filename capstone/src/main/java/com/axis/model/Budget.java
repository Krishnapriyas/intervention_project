package com.axis.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Budget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long budgetId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	private String budgetCategory;
	private double allocatedAmount;

	@OneToMany(mappedBy = "budget")
	private List<Expense> expenses;

	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBudgetCategory() {
		return budgetCategory;
	}

	public void setBudgetCategory(String budgetCategory) {
		this.budgetCategory = budgetCategory;
	}

	public double getAllocatedAmount() {
		return allocatedAmount;
	}

	public void setAllocatedAmount(double allocatedAmount) {
		this.allocatedAmount = allocatedAmount;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public Budget(Long budgetId, User user, String budgetCategory, double allocatedAmount, List<Expense> expenses) {
		super();
		this.budgetId = budgetId;
		this.user = user;
		this.budgetCategory = budgetCategory;
		this.allocatedAmount = allocatedAmount;
		this.expenses = expenses;
	}

	public Budget() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Budget [budgetId=" + budgetId + ", user=" + user + ", budgetCategory=" + budgetCategory
				+ ", allocatedAmount=" + allocatedAmount + ", expenses=" + expenses + "]";
	}

}
