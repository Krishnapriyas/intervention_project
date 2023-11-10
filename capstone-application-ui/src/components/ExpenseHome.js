import React, { useState, useEffect } from 'react';
import BudgetService from '../services/BudgetService';
import './ExpenseHome.css';

const ExpenseHome = () => {
  const [expenses, setExpenses] = useState([]);
  const [newExpense, setNewExpense] = useState({
    expenseCategory: '',
    amount: '',
    date: '',
    description: ''
  });

  const [editedExpense, setEditedExpense] = useState({
    expenseId: null,
    expenseCategory: '',
    amount: '',
    date: '',
    description: ''
  });
//   const [updatedExpense, setUpdatedExpense] = useState({
//     expenseCategory: '',
//     amount: 0,
//     date: '',
//     description: ''
//   });

  useEffect(() => {
    retrieveExpenses();
  }, []);

  const retrieveExpenses = async () => {
    try {
      const response = await BudgetService.getAllExpenses();
      if (response && response.data) {
        setExpenses(response.data);
      }
    } catch (error) {
      console.error('Error retrieving expenses:', error);
    }
  };

  const addNewExpense = async () => {
    try {
      const response = await BudgetService.createExpense(newExpense);
      if (response && response.data) {
        setNewExpense({
          expenseCategory: '',
          amount: '',
          date: '',
          description: ''
        });
        retrieveExpenses();
      }
    } catch (error) {
      console.error('Error adding expense:', error);
    }
  };

  const handleEditExpense = (expense) => {
    setEditedExpense(expense);
  };

  const handleUpdateExpense = async () => {
    try {
      const response = await BudgetService.updateExpense(editedExpense.expenseId, editedExpense);
      if (response && response.data) {
        setEditedExpense({
          expenseId: null,
          expenseCategory: '',
          amount: '',
          date: '',
          description: ''
        });
        retrieveExpenses();
      }
    } catch (error) {
      console.error('Error updating expense:', error);
    }
  };

//   const updateExpense = async (expenseId, updatedData) => {
//     try {
//       const response = await BudgetService.updateExpense(expenseId, updatedData);
//       if (response && response.data) {
//         retrieveExpenses();
//       }
//     } catch (error) {
//       console.error('Error updating expense:', error);
//     }
//   };

//   const updateExpensePrompt = (expenseId) => {
//     const updatedExpense = expenses.find((expense) => expense.expenseId === expenseId);
//     const updatedData = { ...updatedExpense };

//     const category = prompt('Enter updated category:', updatedExpense.expenseCategory);
//     const amount = prompt('Enter updated amount:', updatedExpense.amount);
//     const date = prompt('Enter updated date:', updatedExpense.date);
//     const description = prompt('Enter updated description:', updatedExpense.description);

//     if (category !== null) {
//       updatedData.expenseCategory = category;
//     }

//     if (amount !== null) {
//       updatedData.amount = amount;
//     }
//     if (date !== null) {
//         updatedData.date = date;
//       }
  
//       if (description !== null) {
//         updatedData.description = description;
//       }
  
//       if (category !== null || amount !== null || date !== null || description !== null) {
//         updateExpense(expenseId, updatedData);
//       }
//     };

  const deleteExpense = async (expenseId) => {
    try {
      const response = await BudgetService.deleteExpense(expenseId);
      if (response && response.data) {
        retrieveExpenses();
      }
    } catch (error) {
      console.error('Error deleting expense:', error);
    }
  };

  return (
    <div className="expense-container">
      <h2>Expenses</h2>
      <div>
        <h3>Add New Expense</h3>
        <input
          type="text"
          value={newExpense.expenseCategory}
          onChange={(e) => setNewExpense({ ...newExpense, expenseCategory: e.target.value })}
          placeholder="Expense Category"
          className="input-field"

        />
        <input
          type="number"
          value={newExpense.amount}
          onChange={(e) => setNewExpense({ ...newExpense, amount: e.target.value })}
          placeholder="Amount"
          className="input-field"

        />
        <input
          type="date"
          value={newExpense.date}
          onChange={(e) => setNewExpense({ ...newExpense, date: e.target.value })}
          placeholder="Date"
          className="input-field"

        />
        <input
          type="text"
          value={newExpense.description}
          onChange={(e) => setNewExpense({ ...newExpense, description: e.target.value })}
          placeholder="Description"
          className="input-field"

        />
        <button onClick={addNewExpense}  className="button-investment">Add Expense</button>
      </div>
      {editedExpense.expenseId && (
        <div className="expense-edit-section">
          <h3>Edit Expense</h3>
          <input value={editedExpense.expenseCategory} onChange={(e) => setEditedExpense({ ...editedExpense, expenseCategory: e.target.value })} />
          <input value={editedExpense.amount} onChange={(e) => setEditedExpense({ ...editedExpense, amount: e.target.value })} />
          <input value={editedExpense.date} onChange={(e) => setEditedExpense({ ...editedExpense, date: e.target.value })} />
          <input value={editedExpense.description} onChange={(e) => setEditedExpense({ ...editedExpense, description: e.target.value })} />
          <button onClick={handleUpdateExpense} className="update-btn-invs">Update Expense</button>
        </div>
      )}
      <h3>All Expenses</h3>
      <ul>
        {expenses.map((expense) => (
          <li key={expense.expenseId}>
            <div>
              <div>Category: {expense.expenseCategory}</div>
              <div>Amount: {expense.amount}</div>
              <div>Date: {expense.date}</div>
              <div>Description: {expense.description}</div>

              <button onClick={() => handleEditExpense(expense)} className="update-btn-invs">Edit</button>
 
              <button onClick={() => deleteExpense(expense.expenseId)}className="delete-btn-invs">Delete</button>
            </div>
          </li>
        ))}
      </ul>
      
    </div>
  );
};

export default ExpenseHome;
