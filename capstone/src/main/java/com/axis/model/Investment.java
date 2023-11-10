package com.axis.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Investment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long investmentId;
	private String symbol;
	private double quantity;
	private double purchasePrice;
	private LocalDate purchaseDate;
	private String category;
	@ManyToOne
	@JoinColumn(name = "portfolioId")
	private Portfolio portfolio;

	public Long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(Long investmentId) {
		this.investmentId = investmentId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public Investment(Long investmentId, String symbol, double quantity, double purchasePrice, LocalDate purchaseDate,
			String category, Portfolio portfolio) {
		super();
		this.investmentId = investmentId;
		this.symbol = symbol;
		this.quantity = quantity;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
		this.category = category;
		this.portfolio = portfolio;
	}

	public Investment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Investment [investmentId=" + investmentId + ", symbol=" + symbol + ", quantity=" + quantity
				+ ", purchasePrice=" + purchasePrice + ", purchaseDate=" + purchaseDate + ", category=" + category
				+ ", portfolio=" + portfolio + "]";
	}

}
