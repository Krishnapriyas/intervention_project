import React, { useState, useEffect } from 'react';
import BudgetService from '../services/BudgetService';
import { Link } from 'react-router-dom';
import './PortfolioHome.css'; // Import the CSS file




const PortfolioHome = () => {
  const [portfolios, setPortfolios] = useState([]);
  const [selectedPortfolio, setSelectedPortfolio] = useState(null);
  const [portfolioId, setPortfolioId] = useState('');
  const [portfolioName, setPortfolioName] = useState('');
  const [portfolioDescription, setPortfolioDescription] = useState('');
  const [creationDate, setCreationDate] = useState('');
  const [isEditing, setIsEditing] = useState(false);

  const userId = localStorage.getItem('userId');
  const user = BudgetService.getUser(userId);
  useEffect(() => {
    getAllPortfolios();
  }, []);

  const getAllPortfolios = async () => {
    try {
      const response = await BudgetService.getAllPortfolios();
      setPortfolios(response.data);
    } catch (error) {
      console.error('Error fetching portfolios:', error);
    }
  };

  const createPortfolio = async () => {
    try {
      const newPortfolio = {
        user:user,
        name: portfolioName,
        description: portfolioDescription,
        creationDate: creationDate,
      };
      await BudgetService.createPortfolio(newPortfolio);
      getAllPortfolios();
      setPortfolioName('');
      setPortfolioDescription('');
      setCreationDate('');
    } catch (error) {
      console.error('Error creating portfolio:', error);
    }
  };

  const editPortfolio = (portfolio) => {
    setSelectedPortfolio(portfolio);
    setIsEditing(true);
    setPortfolioName(portfolio.name);
    setPortfolioDescription(portfolio.description);
    setCreationDate(portfolio.creationDate);
    setPortfolioId(portfolio.portfolioId);
  };

  const updatePortfolio = async () => {
    try {
      const updatedPortfolio = {
        id: selectedPortfolio.id,
        name: portfolioName,
        description: portfolioDescription,
        creationDate: creationDate,
      };
      await BudgetService.updatePortfolio(portfolioId,updatedPortfolio);
      getAllPortfolios();
      setPortfolioName('');
      setPortfolioDescription('');
      setCreationDate('');
      setIsEditing(false);
      setSelectedPortfolio(null);
    } catch (error) {
      console.error('Error updating portfolio:', error);
    }
  };

  const deletePortfolio = async (portfolioIdD) => {
    try {
      await BudgetService.deletePortfolio(portfolioIdD);
      getAllPortfolios();
    } catch (error) {
      console.error('Error deleting portfolio:', error);
    }
  };

  return (
    <div className="portfolio-container">
      <h2>Portfolios</h2>
      <div className="portfolio-form">
        <h3>{isEditing ? 'Edit Portfolio' : 'Create New Portfolio'}</h3>
        <label>Name: </label>
        <input
          type="text"
          value={portfolioName}
          onChange={(e) => setPortfolioName(e.target.value)}
        />
        <label>Description: </label>
        <input
          type="text"
          value={portfolioDescription}
          onChange={(e) => setPortfolioDescription(e.target.value)}
        />
        <label>Creation Date: </label>
        <input
          type="date"
          value={creationDate}
          onChange={(e) => setCreationDate(e.target.value)}
        />
        <button className="small-button" onClick={isEditing ? updatePortfolio : createPortfolio}>
          {isEditing ? 'Update' : 'Create'}
        </button>
      </div>
      <div className="portfolio-list">
        <h4>List Of Portfolios</h4>
        {portfolios.map((portfolio) => (
          <div className="portfolio-item" key={portfolio.id}>
          <p>Name: {portfolio.name}</p>
            <p>Description: {portfolio.description}</p>
            <p>Creation Date: {portfolio.creationDate}</p>
            <button className="edit-button small-button" onClick={() => editPortfolio(portfolio)}>
            Edit</button>
            <button className="delete-button small-button" onClick={() => deletePortfolio(portfolio.portfolioId)}>Delete</button>
          </div>
        ))}
      </div>
      <div>      
      <button  className="back-button">
          <Link to="/home" className="white-link">Go Back TO Home</Link>
        </button>
      </div>
    </div>
  );
};

export default PortfolioHome;
