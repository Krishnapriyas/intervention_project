package com.axis.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long portfolioId;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	private String name;
	private String description;
	@OneToMany(mappedBy = "portfolio")
	private List<Investment> investments;

	private LocalDate creationDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Portfolio(Long portfolioId, String name, String description, List<Investment> investments,
			LocalDate creationDate) {
		super();
		this.portfolioId = portfolioId;
		this.name = name;
		this.description = description;
		this.investments = investments;
		this.creationDate = creationDate;
	}

	public Portfolio() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", user=" + user + ", name=" + name + ", description="
				+ description + ", investments=" + investments + ", creationDate=" + creationDate + "]";
	}

}
