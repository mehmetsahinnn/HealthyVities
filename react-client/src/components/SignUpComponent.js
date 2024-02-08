import React, {useEffect, useState} from "react";
import {Link, useNavigate} from "react-router-dom";


function SignUpComponent() {

    const [userData, setUserData] = useState({
        username: "",
        password: "",
        email: "",
        height: "",
        weight: "",
        isAdmin: "0"
    });

    const navigate = useNavigate();

    function handleInputChange(e) {
        const {name, value} = e.target;
        setUserData({...userData, [name]: value});
    }

    async function handleSignUp(e) {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/api/signup', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(userData)
            });
            if (response.ok) {
                navigate('/');
            } else {
                console.error('Sign up failed');
            }
        } catch (error) {
            console.error('Error during sign up:', error);
        }
    }

    const renderInput = (name, placeholder, type = "text") => (
        <div className="input-group">
            <input
                type={type}
                name={name}
                placeholder={placeholder}
                value={userData[name]}
                onChange={handleInputChange}
            />
        </div>
    );

    return (
        <div className="login-container">
            <form className="login-form" onSubmit={handleSignUp}>
                {renderInput("username", "Kullanıcı Adı")}
                {renderInput("password", "Şifre", "password")}
                {renderInput("email", "E-Mail", "email")}
                {renderInput("height", "Boy", "number")}
                {renderInput("weight", "Kilo", "number")}
                <button type="submit">Kayıt Ol</button>
                <div className="extra-actions">
                    <Link to="/" className="register-link">Login</Link>
                </div>
            </form>
        </div>
    );
}

export default SignUpComponent;