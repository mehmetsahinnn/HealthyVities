import React, { useState } from 'react';
import '../styles/ActivityForm.css'

function ActivitiesForm() {
    const [formData, setFormData] = useState({
        username: '',
        activityType: '',
        duration: '',
        distance: '',
        activityDate: ''
    });

    const handleRedirect = () => {
        window.location.href = "/admin-dashboard"
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch(`http://localhost:8080/api/users/username/${formData.username}`);
        const user = await response.json();
        console.log(user);

        const updatedFormData = {
            ...formData,
            user: user
        };

        const postResponse = await fetch('http://localhost:8080/api/activities', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(updatedFormData),
        });

        const postData = await postResponse.json();
        console.log(postData);
        if (postResponse.ok){
            window.location.href = "/admin-dashboard"
        }
    };

    const renderInput = (name, placeholder, type = "text") => (
        <div className="input-group">
            <input
                type={type}
                name={name}
                placeholder={placeholder}
                value={formData[name]}
                onChange={handleInputChange}
            />
        </div>
    );

    return (
        <div className="login-container">
            <form className="login-form" onSubmit={handleSubmit}>
                {renderInput("username", "Username")}
                {renderInput("activityType", "Activity Type")}
                {renderInput("duration", "Duration", "number")}
                {renderInput("distance", "Distance", "number")}
                {renderInput("activityDate", "Activity Date", "date")}
                <button type="submit">Submit</button>
                <button onClick={handleRedirect}>Admin Dashboard</button>
            </form>
        </div>
    );
}

export default ActivitiesForm;