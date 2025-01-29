import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './Pages/LoginPage'; 
import RegistrationPage from './Pages/RegistrationPage'; // Adjust the file path as needed


const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginPage />} />  {/* Default route to login */}
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegistrationPage />} /> {/* Route for Registration Page */}
      </Routes>
    </Router>
  );
};

export default App;
