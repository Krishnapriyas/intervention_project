import React, { useState } from 'react';
import BudgetService from '../services/BudgetService';
import { useNavigate } from 'react-router-dom';


const Registration = () => {
  const navigate = useNavigate();
  const [user, setUser] = useState({
    userName: '',
    password: '',
    email: '',
    fullName: '',
    phoneNumber: ''
  });
  const [registrationStatus, setRegistrationStatus] = useState('');

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setUser({
      ...user,
      [name]: value,
    });
  };

  const handleRegistration = async () => {
    try {
      const response = await BudgetService.register(user);
      if (response.data) {
        setRegistrationStatus('Registration successful');
        navigate('/login');

            }
    } catch (error) {
      console.error('Error during registration:', error);
      setRegistrationStatus('Registration failed. Please try again.');
    }
  };

  return (
    <div className="registration-container">
      <h1>Registration</h1>
      <form>
        <div>
          <label>Username:</label>
          <input type="text" name="userName" value={user.userName} onChange={handleInputChange} />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" name="password" value={user.password} onChange={handleInputChange} />
        </div>
        <div>
          <label>Email:</label>
          <input type="email" name="email" value={user.email} onChange={handleInputChange} />
        </div>
        <div>
          <label>Full Name:</label>
          <input type="text" name="fullName" value={user.fullName} onChange={handleInputChange} />
        </div>
        <div>
          <label>Phone Number:</label>
          <input type="tel" name="phoneNumber" value={user.phoneNumber} onChange={handleInputChange} />
        </div>
        <button type="button" onClick={handleRegistration}>Register</button>
      </form>
      {registrationStatus && <p className="registration-status">{registrationStatus}</p>}
    </div>
  );
};

export default Registration;
