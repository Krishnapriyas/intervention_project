import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import BudgetService from '../services/BudgetService';
import { Link } from 'react-router-dom';
import './CalculationsHome.css';




const CalculationsHome = () => {
  const [calculationType, setCalculationType] = useState('calculateLoanEMI');
  const [calculation, setCalculation] = useState({});
  const [result, setResult] = useState(null);

  const handleCalculationTypeChange = (e) => {
    setCalculationType(e.target.value);
    setCalculation({}); 
    setResult(null);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setCalculation({
      ...calculation,
      [name]: value,
    });
  };

  const calculate = async () => {
    try {
      let response = null;

      if (calculationType === 'calculateLoanEMI') {
        response = await BudgetService.calculateLoanEMI(calculation);
        console.log(response);
      } else if (calculationType === 'calculateInvestmentGrowth') {
        response = await BudgetService.calculateInvestmentGrowth(calculation);
      } else if (calculationType === 'budgetCategorySpendingPercentage') {
        response = await BudgetService.calculateBudgetCategorySpendingPercentage(calculation);
        console.log(response);
      } else if (calculationType === 'expenseCategorySpendingPercentage') {
        response = await BudgetService.calculateExpenseCategorySpendingPercentage(calculation);
        console.log(response);
      } else if (calculationType === 'netSavings') {
        response = await BudgetService.calculateNetSavings(calculation);
        console.log(response);
      }

      if (response && response.data) {
        setResult(response.data);
      } else {
        setResult('Error: Invalid response');
      }
    } catch (error) {
      console.error('Error calculating:', error);
      setResult('Error: Invalid request');
    }
  };

  return (
<div className="calc-container">
      <h2>Financial Calculator</h2>
      <div>
        <label>Calculation Type: </label>
        <select onChange={handleCalculationTypeChange} value={calculationType}>
          <option value="calculateLoanEMI">Calculate Loan EMI</option>
          <option value="calculateInvestmentGrowth">Calculate Investment Growth</option>
          <option value="budgetCategorySpendingPercentage">Budget Category Spending Percentage</option>
          <option value="expenseCategorySpendingPercentage">Expense Category Spending Percentage</option>
          <option value="netSavings">Net Savings</option>
        </select>
      </div>
      {calculationType === 'calculateLoanEMI' && (
        <div>
          <label>Principal Amount: </label>
          <input
            type="text"
            name="amount"
            value={calculation.amount}
            onChange={handleInputChange}
          />
          <label>Annual Interest Rate: </label>
          <input
            type="text"
            name="interestRate"
            value={calculation.interestRate}
            onChange={handleInputChange}
          />
          <label>Tenure In Months: </label>
          <input
            type="text"
            name="tenureInMonths"
            value={calculation.tenureInMonths}
            onChange={handleInputChange}
          />
        </div>
        
      )}
      {calculationType === 'budgetCategorySpendingPercentage' && (
        <div>
          <label>Actual Spending: </label>
          <input
            type="text"
            name="actualSpending"
            value={calculation.actualSpending}
            onChange={handleInputChange}
          />
          <label>Budgeted Amount: </label>
          <input
            type="text"
            name="budgetedAmount"
            value={calculation.budgetedAmount}
            onChange={handleInputChange}
          />
        </div>
        
      )}
      {calculationType === 'calculateInvestmentGrowth' && (
        <div>
          <label>Initial Investment </label>
          <input
            type="text"
            name="amount"
            value={calculation.amount}
            onChange={handleInputChange}
          />
          <label>Annual Interest Rate </label>
          <input
            type="text"
            name="interestRate"
            value={calculation.interestRate}
            onChange={handleInputChange}
          />
          <label>Compounding Frequency </label>
          <input
            type="text"
            name="NoCompoundedInterest"
            value={calculation.NoCompoundedInterest}
            onChange={handleInputChange}
          />
          <label>Tenure In Months </label>
          <input
            type="text"
            name="tenureInMonths"
            value={calculation.tenureInMonths}
            onChange={handleInputChange}
          />
        </div>
        
      )}
       {calculationType === 'expenseCategorySpendingPercentage' && (
        <div>
          <label>Total Expenses In Category </label>
          <input
            type="text"
            name="totalExpensesInCategory"
            value={calculation.totalExpensesInCategory}
            onChange={handleInputChange}
          />
          <label>Total Expenses: </label>
          <input
            type="text"
            name="totalExpenses"
            value={calculation.totalExpenses}
            onChange={handleInputChange}
          />
        </div>
        
        
      )}
      {calculationType === 'netSavings' && (
        <div>
          <label>Total Income </label>
          <input
            type="text"
            name="totalIncome"
            value={calculation.totalIncome}
            onChange={handleInputChange}
          />
          <label>Total Expenses: </label>
          <input
            type="text"
            name="totalExpenses"
            value={calculation.totalExpenses}
            onChange={handleInputChange}
          />
          
        </div>
        
        
      )}
      <button className="calculate-button "  onClick={calculate}>Calculate</button>
      <div className="result">
        <h3>Result: {result}</h3>
      </div>
      <div>
      <button className="link-button small-button">
          <Link to="/home" className="white-link">Go Back TO Home</Link>
        </button>
      </div>
    </div>
  );
};

export default CalculationsHome;
