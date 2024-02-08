import React, {useState} from "react";
import '../styles/Login.css';
import logo from '../a.png'
import {Link} from "react-router-dom";

function Login() {

    const [credentials, setCredentials] = useState({
        username: "",
        password: "",
        userId: "",
        height: "",
        weight: "",
        isAdmin: false
    });

    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setCredentials(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const setLocalStorage = (data) => {
        for (const key in data) {
            localStorage.setItem(key, data[key]);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({username: credentials.username, password: credentials.password})
        });

        const data = await response.json();

        if (response.ok) {
            setCredentials(data);
            setLocalStorage(data);
            localStorage.setItem('userToken', data.token);
            window.location.href = '/dashboard';
        }
    };

    const renderInput = (name, placeholder, type = "text") => (
        <div className="input-group">
            <input
                type={type}
                name={name}
                placeholder={placeholder}
                value={credentials[name]}
                onChange={handleInputChange}
            />
        </div>
    );

    return (
        <div className="login-container">
            <img src={logo} alt="HEALTHYVITIES" className="hea-logo"/>
            <form className="login-form" onSubmit={handleSubmit}>
                {renderInput("username", "Username")}
                {renderInput("password", "Password", "password")}
                <button type="submit">Sign In</button>

                <div className="extra-actions">
                    <Link to="/sign-up" className="register-link">Register</Link>
                </div>
            </form>
        </div>
    )
}

export default Login;