import React, {useEffect} from "react";
import { useNavigate } from "react-router-dom";
import Sidebar from "./Sidebar";
import MainContent from "./MainContent";
import "../styles/UserDashboard.css";


function UserDashboard() {
    const navigate = useNavigate();

    useEffect(() => {
        const token = localStorage.getItem("userToken");
        if (!token) {
            navigate("/");
        }
    }, [navigate]);

    return (
        <div className="dashboard-container">
            <Sidebar/>
            <MainContent/>
        </div>
    );

}

export default UserDashboard;
