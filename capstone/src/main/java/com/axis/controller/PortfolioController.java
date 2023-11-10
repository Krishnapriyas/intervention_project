package com.axis.controller;

import java.util.List;
import java.util.Optional;

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

import com.axis.model.Portfolio;
import com.axis.service.PortfolioService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {
	@Autowired
	private PortfolioService portfolioService;

	@PostMapping("/createPortfolio")
	public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
		return portfolioService.createPortfolio(portfolio);
	}

	@GetMapping("/getAllPortfolios")
	public List<Portfolio> getAllPortfolios() {
		return portfolioService.getAllPortfolios();
	}
	

	@GetMapping("/getPortfolio/{portfolioId}")
	public Optional<Portfolio> getPortfolio(@PathVariable Long portfolioId) {
		return portfolioService.getPortfolioById(portfolioId);
	}

	/*
	 * @GetMapping("/user/{userId}") public List<Portfolio>
	 * getUserPortfolios(@PathVariable Long userId) { return
	 * portfolioService.getAllPortfoliosByUser(userId); }
	 */

	@PutMapping("/updatePortfolio/{portfolioId}")
	public Portfolio updatePortfolio(@PathVariable Long portfolioId, @RequestBody Portfolio portfolio) {
		portfolio.setPortfolioId(portfolioId);
		return portfolioService.updatePortfolio(portfolio);
	}

	@DeleteMapping("/deletePortfolio/{portfolioId}")
	public void deletePortfolio(@PathVariable Long portfolioId) {
		portfolioService.deletePortfolio(portfolioId);
	}
}
