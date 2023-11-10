import React from 'react';
import { Link } from 'react-router-dom';
import './HomePage.css';

const HomePage = () => {
  const handleLogout = () => {
    localStorage.removeItem('userId');
  };
  return (
    <div className="container">
      <h2>Navigation To Your Requirements</h2>
      <div className="buttons-row">
        <button>
          <Link to="/portfolioHome" className="white-link">Go to Portfolio Home</Link>
        </button>
        <button>
          <Link to="/budgetHome" className="white-link">Go to Budget Home</Link>
        </button>
        <button>
          <Link to="/investmentHome" className="white-link">Go to Investments Home</Link>
        </button>
        <button>
          <Link to="/expenseHome" className="white-link">Go to Expenses Home</Link>
        </button>
        <button>
          <Link to="/calculations" className="white-link">Go to Calculations</Link>
        </button>
      </div>
      <div>
      <button onClick={handleLogout}>
        <Link to="/login" className="white-link">Logout</Link>
      </button>
      </div>
    </div>
  );
};

export default HomePage;
