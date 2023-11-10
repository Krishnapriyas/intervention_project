package com.axis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.BudgetDTO;
import com.axis.dto.InvestmentDTO;
import com.axis.model.Budget;
import com.axis.model.Investment;
import com.axis.model.Portfolio;
import com.axis.repository.InvestmentRepository;

@Service
public class InvestmentService {
    @Autowired
    private InvestmentRepository investmentRepository;
    @Autowired
    private PortfolioService portfolioService;

    public Investment createInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public Investment getInvestmentById(Long investmentId) {
        return investmentRepository.findById(investmentId).orElse(null);
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public Investment updateInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public void deleteInvestment(Long investmentId) {
        investmentRepository.deleteById(investmentId);
    }

	public Investment createInvestmentD(InvestmentDTO investmentdto) {
		Investment investment = new Investment();
		investment.setCategory(investmentdto.getCategory());
		investment.setPurchaseDate(investmentdto.getPurchaseDate());
		investment.setPurchasePrice(investmentdto.getPurchasePrice());
		investment.setQuantity(investmentdto.getQuantity());
		investment.setSymbol(investmentdto.getSymbol());
		System.out.println(investment);
		//Portfolio portfolio = new Portfolio();
		//portfolio = 
        return investmentRepository.save(investment);

		
			}
	
    public List<InvestmentDTO> getAllInvestments1() {
        List<Investment> investments = investmentRepository.findAll();
        List<InvestmentDTO> investmentsDTO = new ArrayList<>();

        for (Investment investment : investments) {
            InvestmentDTO investmentDTO = new InvestmentDTO();
            investmentDTO.setInvestmentId(investment.getInvestmentId());
            investmentDTO.setCategory(investment.getCategory());
    		investmentDTO.setPurchaseDate(investment.getPurchaseDate());
    		investmentDTO.setPurchasePrice(investment.getPurchasePrice());
    		investmentDTO.setQuantity(investment.getQuantity());
    		investmentDTO.setSymbol(investment.getSymbol());
            investmentsDTO.add(investmentDTO);
        }
        return investmentsDTO;

    }
}
