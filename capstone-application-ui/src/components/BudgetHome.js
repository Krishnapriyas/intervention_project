import React, { useState, useEffect } from 'react';
import BudgetService from '../services/BudgetService';
import { Link } from 'react-router-dom';
import './BudgetHome.css';


const BudgetHome = () => {
  const [budgets, setBudgets] = useState([]);
  const [currentBudget, setCurrentBudget] = useState(null);
  const [currentIndex, setCurrentIndex] = useState(-1);
  const [newBudget, setNewBudget] = useState({
    budgetCategory: '',
    allocatedAmount: 0,
  });

  const retrieveBudgets = () => {
    BudgetService.getAllBudgets()
      .then((response) => {
        setBudgets(response.data);
      })
      .catch((e) => {
        console.error(e);
      });
  };

  useEffect(() => {
    retrieveBudgets();
  }, []);

  const setActiveBudget = (budget, index) => {
    setCurrentBudget(budget);
    setCurrentIndex(index);
  };
  const handleCreateBudget = () => {
    const userId = localStorage.getItem('userId');
    console.log(userId);
  
    if (userId) {
      // const updatedNewBudget = { ...newBudget, user: user };
  
      BudgetService.createBudget(newBudget,userId)
        .then(() => {
          retrieveBudgets();
          setNewBudget({
            budgetCategory: '',
            allocatedAmount: 0,
          });
        })
        .catch((e) => {
          console.error(e);
        });
    }
  };
  
  const handleUpdateBudget = () => {
    if (currentBudget) {
      BudgetService.updateBudget(currentBudget.budgetId, currentBudget)
        .then(() => {
          retrieveBudgets();
          setCurrentBudget(null);
        })
        .catch((e) => {
          console.error(e);
        });
    }
  };
  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setCurrentBudget({ ...currentBudget, [name]: value });
  };

  const handleDeleteBudget = () => {
    if (currentBudget) {
      BudgetService.deleteBudget(currentBudget.budgetId)
        .then(() => {
          retrieveBudgets();
        })
        .catch((e) => {
          console.error(e);
        });
    }
  };

  return (
<div className="budget-container">
        <h2>Budgets</h2>
      <div className="row">
        <div className="col-md-6 budget-list-container">
          <h4>Budget List</h4>
          <ul className="list-group">
            {budgets &&
              budgets.map((budget, index) => (
                <li
                  className={`list-group-item ${index === currentIndex ? 'active' : ''}`}
                  onClick={() => setActiveBudget(budget, index)}
                  key={index}
                >
                  {budget.budgetCategory}
                </li>
              ))}
          </ul>
        </div>
        <div className="col-md-6 budget-details-container">
          {currentBudget ? (
            <div>
              <h4>Budget Details</h4>
              <div>
                <label>
                  <strong>Budget Category:</strong>
                </label>{' '}
                <input
                  type="text"
                  name="budgetCategory"
                  value={currentBudget.budgetCategory}
                  onChange={handleInputChange}
                />
                {/* {currentBudget.budgetCategory} */}
              </div>
              <div>
                <label>
                  <strong>Allocated Amount:</strong>
                </label>{' '}
                <input
                  type="number"
                  name="allocatedAmount"
                  value={currentBudget.allocatedAmount}
                  onChange={handleInputChange}
                />
                {/* {currentBudget.allocatedAmount} */}
              </div>
              {/* <div>
                <label>
                  <strong>Creation Date:</strong>
                </label>{' '}
                {currentBudget.creationDate}
              </div> */}
              <div className="buttons-container">
              <button className="small-button " onClick={handleDeleteBudget}>Delete</button>
              <button className="small-button " onClick={handleUpdateBudget}>Update</button>
              </div>
            </div>
          ) : (
            <div>
              <br />
              <p>Please click on a budget to view details.</p>
            </div>
          )}</div>
<div className="create-budget-container">
              <h4>Create New Budget</h4>
            <form>
              <div className="form-group">
                <label htmlFor="budgetCategory">Budget Category</label>
                <input
                  type="text"
                  className="form-control"
                  id="budgetCategory"
                  name="budgetCategory"
                  value={newBudget.budgetCategory}
                  onChange={(e) => setNewBudget({ ...newBudget, budgetCategory: e.target.value })}
                />
              </div>
              <div className="form-group">
                <label htmlFor="allocatedAmount">Allocated Amount</label>
                <input
                  type="number"
                  className="form-control"
                  id="allocatedAmount"
                  name="allocatedAmount"
                  value={newBudget.allocatedAmount}
                  onChange={(e) => setNewBudget({ ...newBudget, allocatedAmount: e.target.value })}
                />
              </div>
              <div className="buttons-container">

              <button className="small-button " type="button" onClick={handleCreateBudget}>
                Create
              </button>
      
        </div>
            </form>
            </div>
            
        </div>
        <div>
        <button className="small-button ">
          <Link to="/home" className="white-link">Go Back TO Home</Link>
        </button>
        </div>
      </div>

  );
};

export default BudgetHome;
