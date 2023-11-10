import React, { useState, useEffect } from 'react';
import BudgetService from '../services/BudgetService';
import './InvestmentHome.css';
import { Link } from 'react-router-dom';


const InvestmentHome = () => {
  const [investments, setInvestments] = useState([]);
  const [newInvestment, setNewInvestment] = useState({
    category: '',
    purchaseDate: '',
    purchasePrice: '',
    quantity: '',
    symbol: ''
  });
  const [editedInvestment, setEditedInvestment] = useState({
    category: '',
    purchaseDate: '',
    purchasePrice: '',
    quantity: '',
    symbol: ''
  });

  useEffect(() => {
    retrieveInvestments();
  }, []);

  const retrieveInvestments = async () => {
    try {
      const response = await BudgetService.getAllInvestments();
      if (response && response.data) {
        setInvestments(response.data);
      }
    } catch (error) {
      console.error('Error retrieving investments:', error);
    }
  };

  const addNewInvestment = async () => {
    try {
      const response = await BudgetService.createInvestment(newInvestment);
      if (response && response.data) {
        setNewInvestment({
          category: '',
          purchaseDate: '',
          purchasePrice: '',
          quantity: '',
          symbol: ''
        });
        retrieveInvestments();
      }
    } catch (error) {
      console.error('Error adding investment:', error);
    }
  };

  const updateInvestment = async (investmentId, updatedData) => {
    try {
      const response = await BudgetService.updateInvestment(investmentId, updatedData);
      if (response && response.data) {
        retrieveInvestments();
      }
    } catch (error) {
      console.error('Error updating investment:', error);
    }
  };

  const deleteInvestment = async (investmentId) => {
    try {
      const response = await BudgetService.deleteInvestment(investmentId);
      if (response && response.data) {
        retrieveInvestments();
      }
    } catch (error) {
      console.error('Error deleting investment:', error);
    }
  };
  const handleEdit = (investment) => {
    setEditedInvestment({ ...investment });
  };
  const handleUpdateInvestment = () => {
    updateInvestment(editedInvestment.investmentId, editedInvestment);
    setEditedInvestment({
      category: '',
      purchaseDate: '',
      purchasePrice: '',
      quantity: '',
      symbol: ''
    });
  };
  return (
    <div className="container-investment">
      <h2 className="h2-investment">Investments</h2>
      <div>
        <h3 className="h3-investment">Add New Investment</h3>
        <input
          type="text"
          value={newInvestment.category}
          onChange={(e) => setNewInvestment({ ...newInvestment, category: e.target.value })}
          placeholder="Category"
          className="input-field"
        />
        <input
          type="date"
          value={newInvestment.purchaseDate}
          onChange={(e) => setNewInvestment({ ...newInvestment, purchaseDate: e.target.value })}
          placeholder="Purchase Date"
          className="input-field"
        />
        
        <input
          type="number"
          value={newInvestment.purchasePrice}
          onChange={(e) => setNewInvestment({ ...newInvestment, purchasePrice: e.target.value })}
          placeholder="Purchase Price"
          className="input-field"
        />
        <input
          type="number"
          value={newInvestment.quantity}
          onChange={(e) => setNewInvestment({ ...newInvestment, quantity: e.target.value })}
          placeholder="Quantity"
          className="input-field"
        />
        <input
          type="text"
          value={newInvestment.symbol}
          onChange={(e) => setNewInvestment({ ...newInvestment, symbol: e.target.value })}
          placeholder="Symbol"
          className="input-field"
        />
        <button onClick={addNewInvestment} className="button-investment">
          Add Investment
        </button>
      </div>
      {editedInvestment.investmentId && (
  <div className="investment-edit-section">
    <h3>Edit Investment</h3>
    {/* Input fields to edit an investment */}
    <input
      type="text"
      value={editedInvestment.category}
      onChange={(e) => setEditedInvestment({ ...editedInvestment, category: e.target.value })}
      placeholder="Category"
      className="input-field"
    />
    <input
      type="date"
      value={editedInvestment.purchaseDate}
      onChange={(e) => setEditedInvestment({ ...editedInvestment, purchaseDate: e.target.value })}
      placeholder="Purchase Date"
      className="input-field"
    />
    <input
      type="number"
      value={editedInvestment.purchasePrice}
      onChange={(e) => setEditedInvestment({ ...editedInvestment, purchasePrice: e.target.value })}
      placeholder="Purchase Price"
      className="input-field"
    />
    <input
      type="number"
      value={editedInvestment.quantity}
      onChange={(e) => setEditedInvestment({ ...editedInvestment, quantity: e.target.value })}
      placeholder="Quantity"
      className="input-field"
    />
    <input
      type="text"
      value={editedInvestment.symbol}
      onChange={(e) => setEditedInvestment({ ...editedInvestment, symbol: e.target.value })}
      placeholder="Symbol"
      className="input-field"
    />

    <button onClick={handleUpdateInvestment} className="button-investment">
      Update Investment
    </button>
  </div>
)}

      <h3 className="h3-investment">All Investments</h3>
      <ul>
        {investments.map((investment) => (
          <li key={investment.investmentId} className="li-investment">
            <div className="investment-details">
              <div>ID: {investment.investmentId}</div>
              <div>Category: {investment.category}</div>
              <div>Purchase Date: {investment.purchaseDate}</div>
              <div>Purchase Price: {investment.purchasePrice}</div>
              <div>Quantity: {investment.quantity}</div>
              <div>Symbol: {investment.symbol}</div>
              <div>
              <button onClick={() => handleEdit(investment)} className="update-btn-invs">
                  Edit
                </button>
              <button onClick={() => deleteInvestment(investment.investmentId)} className="delete-btn-invs">
                Delete
              </button>
              </div>
            </div>
          </li>
        ))}
      </ul>
    

      <button  className="back-button">
          <Link to="/home" className="white-link">Go Back TO Home</Link>
        </button>
    </div>
  );
};

export default InvestmentHome;
