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

import com.axis.dto.InvestmentDTO;
import com.axis.model.Investment;
import com.axis.service.InvestmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
	@Autowired
	private InvestmentService investmentService;

	@PostMapping("/createInvestment")
	public Investment createInvestment(@RequestBody InvestmentDTO investmentdto) {
		return investmentService.createInvestmentD(investmentdto);
	}

	@GetMapping("/getInvestment/{investmentId}")
	public Investment getInvestment(@PathVariable Long investmentId) {
		return investmentService.getInvestmentById(investmentId);
	}

	@GetMapping("/getAllInvestments")
	public List<InvestmentDTO> getAllInvestments(){
		return investmentService.getAllInvestments1();
	}
	/*
	 * @GetMapping("/user/{userId}") public List<Investment>
	 * getUserInvestments(@PathVariable Long userId) { return
	 * investmentService.getAllInvestmentsByUser(userId); }
	 */

	@PutMapping("/updateInvestment/{investmentId}")
	public Investment updateInvestment(@PathVariable Long investmentId, @RequestBody Investment investment) {
		investment.setInvestmentId(investmentId);
		return investmentService.updateInvestment(investment);
	}

	@DeleteMapping("/deleteInvestment/{investmentId}")
	public void deleteInvestment(@PathVariable Long investmentId) {
		investmentService.deleteInvestment(investmentId);
	}
}
