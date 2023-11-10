import './App.css';
import { BrowserRouter, Routes, Route,withRouter } from "react-router-dom";

import React from 'react';
import Login from './components/Login';
import CalculationsHome from './components/CalculationsHome';
import Registration from './components/Registeration';
import PortfolioHome from './components/PortfolioHome';
import BudgetHome from './components/BudgetHome';
import HomePage from './components/HomePage';
import InvestmentHome from './components/InvestmentHome';
import ExpenseHome from './components/ExpenseHome';


function App() {
  return (
    <div id="app-container">
    <BrowserRouter>

<div id="content">
        <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/calculations" element={<CalculationsHome />} />
        <Route path="/registeration" element={<Registration />} />
        <Route path="/portfolioHome" element={<PortfolioHome/>}/>
        <Route path="/budgetHome" element={<BudgetHome/>}/>
        <Route path="/home" element={<HomePage/>}/>
        <Route path="/investmentHome" element={<InvestmentHome/>}/>
        <Route path="/expenseHome" element={<ExpenseHome/>}/>

        </Routes>
      </div>
    </BrowserRouter>
  </div>
);
}

export default App;
