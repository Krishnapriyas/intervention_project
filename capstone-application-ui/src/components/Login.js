import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import BudgetService from '../services/BudgetService';
import './Login.css'; 

const Login = () => {
  const navigate = useNavigate();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const login = async () => {
    const user = {
        userName: username, 
        password: password
    };

    try {
      const response = await BudgetService.login(user);
      console.log(response);

      if (response.data && response.data.userId) {
        localStorage.setItem('userId', response.data.userId);
        navigate('/home');
        
      } else {
        setError('Invalid username or password');
      }
    } catch (error) {
      console.log(error);
      setError('Invalid username or password');
    }
  };

  
 
  const navigateToRegistrationPage = () => {
    navigate('/registeration');
  };

  const handleLogin = (e) => {
    e.preventDefault();
    login();
  };

  

  return (
    <div className="login-container">
      <h1>Login</h1>
      <form onSubmit={handleLogin} className="login-form">
        <div>
          <label>Username</label>
          <input type="text" value={username} onChange={handleUsernameChange} />
        </div>
        <div>
          <label>Password</label>
          <input type="password" value={password} onChange={handlePasswordChange} />
        </div>
        <button type="submit" className='small-button' style={{ marginBottom: '10px' }}>Login</button>
        <button type="button" className='small-button' onClick={navigateToRegistrationPage}>New User? Register Here</button>
      </form>
      {error && <p className="error-message">{error}</p>}
    </div>
  );
};

export default Login;
