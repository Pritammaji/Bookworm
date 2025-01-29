import React, { useState } from 'react';
import './RegistrationPage.css';

const RegistrationPage = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    confirmPassword: '',
    mobileNo: '',
    dob: '',
  });

  const [error, setError] = useState({});
  const [successMessage, setSuccessMessage] = useState('');

  const handleChange = (e) => {
    const { id, value } = e.target;
    setFormData({ ...formData, [id]: value });
  };

  const validateForm = () => {
    let errors = {};

    if (!formData.name) errors.name = 'Full name is required';
    if (!formData.email) errors.email = 'Email is required';
    if (!formData.password) errors.password = 'Password is required';
    if (!formData.confirmPassword) errors.confirmPassword = 'Confirm Password is required';
    if (!formData.mobileNo) errors.mobileNo = 'Mobile number is required';
    if (!formData.dob) errors.dob = 'Date of birth is required';

    if (formData.password !== formData.confirmPassword) {
      errors.confirmPassword = 'Passwords do not match';
    }

    if (!/^\d{10}$/.test(formData.mobileNo)) {
      errors.mobileNo = 'Mobile number must be 10 digits';
    }

    if (formData.email === 'user@example.com') {
      errors.email = 'Email already in use';
    }

    return errors;
  };

  const handleRegistration = (e) => {
    e.preventDefault();

    const validationErrors = validateForm();
    if (Object.keys(validationErrors).length > 0) {
      setError(validationErrors);
      setSuccessMessage('');
      return;
    }

    setSuccessMessage('Registration successful!');
    setError({});
    localStorage.setItem('userEmail', formData.email);
  };

  return (
    <div className="registration-page">
      <div className="registration-container">
        <h1 className="registration-title">Create Account</h1>
        <form onSubmit={handleRegistration} className="registration-form">
          {[
            { id: 'name', label: 'Full Name', type: 'text', placeholder: 'Enter your full name' },
            { id: 'email', label: 'Email', type: 'email', placeholder: 'Enter your email' },
            { id: 'mobileNo', label: 'Mobile Number', type: 'tel', placeholder: 'Enter your mobile number' },
            { id: 'dob', label: 'Date of Birth', type: 'date', placeholder: '' },
            { id: 'password', label: 'Password', type: 'password', placeholder: 'Create a password' },
            { id: 'confirmPassword', label: 'Confirm Password', type: 'password', placeholder: 'Confirm your password' },
          ].map(({ id, label, type, placeholder }) => (
            <div key={id} className="form-group">
              <label htmlFor={id} className="form-label">{label}</label>
              <input
                type={type}
                id={id}
                className={`form-input ${error[id] ? 'input-error' : ''}`}
                value={formData[id]}
                onChange={handleChange}
                placeholder={placeholder}
                required
              />
              {error[id] && <div className="error-message">{error[id]}</div>}
            </div>
          ))}

          <button type="submit" className="register-btn">Register</button>
        </form>

        {successMessage && <div className="success-message">{successMessage}</div>}
      </div>
    </div>
  );
};

export default RegistrationPage;
