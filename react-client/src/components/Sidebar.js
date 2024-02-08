import React, {useEffect, useState} from 'react';
import "../styles/Sidebar.css";

function Sidebar() {
    const [profile, setProfile] = useState({height: '', weight: ''});
    const userId = localStorage.getItem("userId");

    useEffect(() => {
        if (userId) {
            fetch(`http://localhost:8080/api/users/${userId}`,
                {
                    headers: {
                        'Authorization': 'Bearer ' + localStorage.getItem('userToken')
                    }
                    ,
                })
                .then(response => response.json())
                .then(data => {
                    setProfile({
                        height: data.height,
                        weight: data.weight,
                        isAdmin: data.isAdmin
                    });
                })
                .catch(err => {
                    console.error("Error is: ", err);
                });
        }

    }, []);


    const handleLogout = () => {
        localStorage.removeItem('username');
        localStorage.removeItem('userToken');
        localStorage.removeItem('height');
        localStorage.removeItem('weight');

        window.location.href = '/';
    };

    return (
        <aside className="sidebar">
            <div className="user-profile">
                <div className="user-avatar">
                    <img
                        src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/64px-Default_pfp.svg.png"
                        alt="pp small"/>
                </div>
                <br/>
                <div className="user-name">{localStorage.getItem("username")}</div>
            </div>


            <nav className="user-features">
                <ul>
                    <br/>
                    <li>Height : {localStorage.getItem("height")}</li>
                    <br/>
                    <li>Weight : {localStorage.getItem("weight")}</li>
                </ul>
            </nav>
            <div className="logout-container">
                {profile.isAdmin === 1 && (
                    <button onClick={() => { window.location.href = '/admin-dashboard' }} className="admin-dashboard-button">
                        Admin Dashboard
                    </button>
                )}
                <button onClick={handleLogout} className="logout-button">Log Out</button>
            </div>
        </aside>
    );
}

export default Sidebar;
