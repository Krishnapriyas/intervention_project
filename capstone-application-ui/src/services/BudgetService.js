import axios from "axios";

const API_BASE_URL = "http://localhost:8081/";

class BudgetService{

    
  login(user) {
    return axios.post(API_BASE_URL + "api/users/login", user);
    }
  register(user) {
    return axios.post(API_BASE_URL + "api/users/register", user);
    }
    getUser(userId){
        return axios.get(API_BASE_URL+"api/users/getUser/"+userId);
    }
    calculateLoanEMI(calculate){
        return axios.post(API_BASE_URL+"api/financial/calculateLoanEMI",calculate);
    }
    calculateBudgetCategorySpendingPercentage(calculate){
        return axios.post(API_BASE_URL+"api/financial/budgetCategorySpendingPercentage",calculate);
    }
    calculateExpenseCategorySpendingPercentage(calculate){
        return axios.post(API_BASE_URL+"api/financial/expenseCategorySpendingPercentage",calculate);
    }
    calculateNetSavings(calculate){
        return axios.post(API_BASE_URL+"api/financial/netSavings",calculate);
    }

    calculateInvestmentGrowth(calculate){
        return axios.post(API_BASE_URL+"api/financial/calculateInvestmentGrowth",calculate);
    }

    getAllPortfolios(){
        return axios.get(API_BASE_URL+"api/portfolios/getAllPortfolios");

    }
    getPortfolio(portfolioId){
        return axios.get(API_BASE_URL+"api/portfolios/getPortfolio"+portfolioId);
    }
    createPortfolio(newPortfolio){
        return axios.post(API_BASE_URL+"api/portfolios/createPortfolio",newPortfolio);

    }
    updatePortfolio(portfolioId,updatedPortfolio){
        return axios.put(API_BASE_URL+"api/portfolios/updatePortfolio/"+portfolioId,updatedPortfolio);
    }
    deletePortfolio(portfolioId){
        return axios.delete(API_BASE_URL+"api/portfolios/deletePortfolio/"+portfolioId);
    }
    getAllBudgets(){
        return axios.get(API_BASE_URL+"api/budgets/getAllBudgets");
    }
    createBudget(budget, userId) {
        return axios.post(API_BASE_URL + "api/budgets/createBudget",budget,userId);
    }
      
      
    updateBudget(budgetId,budget){
        return axios.put(API_BASE_URL+"api/budgets/updateBudget/"+budgetId,budget);
    }
    deleteBudget(budgetId){
        return axios.delete(API_BASE_URL+"api/budgets/deleteBudget/"+budgetId);
    }

    getAllInvestments(){
        return axios.get(API_BASE_URL+"api/investments/getAllInvestments");
    }
    createInvestment(investment) {
        return axios.post(API_BASE_URL + "api/investments/createInvestment",investment);
    }
      
      
    updateInvestment(investmentId,investment){
        return axios.put(API_BASE_URL+"api/investments/updateInvestment/"+investmentId,investment);
    }
    deleteInvestment(investmentId){
        return axios.delete(API_BASE_URL+"api/investments/deleteInvestment/"+investmentId);
    }

    getAllExpenses(){
        return axios.get(API_BASE_URL+"api/expenses/getAllExpenses");
    }
    createExpense(expense) {
        return axios.post(API_BASE_URL + "api/expenses/createExpense",expense);
    }
      
      
    updateExpense(expenseId,expense){
        return axios.put(API_BASE_URL+"api/expenses/updateExpense/"+expenseId,expense);
    }
    deleteExpense(expenseId){
        return axios.delete(API_BASE_URL+"api/expenses/deleteExpense/"+expenseId);
    }
}

export default new BudgetService();