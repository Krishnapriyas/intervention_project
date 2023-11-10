package com.axis.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expenseId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	private String expenseCategory;
	private double amount;
	private LocalDate date;
	private String description;

	@ManyToOne
	@JoinColumn(name = "budgetId")
	private Budget budget;

	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public Expense(Long expenseId, User user, String expenseCategory, double amount, LocalDate date, String description,
			Budget budget) {
		super();
		this.expenseId = expenseId;
		this.user = user;
		this.expenseCategory = expenseCategory;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.budget = budget;
	}

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Expense [id=" + expenseId + ", user=" + user + ", expenseCategory=" + expenseCategory + ", amount="
				+ amount + ", date=" + date + ", description=" + description + ", budget=" + budget + "]";
	}

}
