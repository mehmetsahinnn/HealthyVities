import './styles/App.css';
import UserContext from "./components/UserContext";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Login from "./components/Login";
import {useState} from "react";
import UserDashboard from "./components/UserDashboard";
import SignUpComponent from "./components/SignUpComponent";
import AdminDashboard from "./components/AdminDashboard";
import ActivitiesForm from "./components/ActivitiesForm";
import HealthRecordComponent from "./components/HealthRecordComponent";
import NutritionDiaryComponent from "./components/NutritionDiaryComponent";
import NutritionDiaryForm from "./components/NutritionDiaryForm";
import HealthRecordsForm from "./components/HealthRecordsForm";

function App() {
    const [user, setUser] = useState(null);
    return (
        <UserContext.Provider value={{user, setUser}}>
            <Router>
                <Routes>
                    <Route path="/" element={<Login/>}/>
                    <Route path="/sign-up" element={<SignUpComponent/>}/>
                    <Route path="/dashboard" element={<UserDashboard />} />
                    <Route path="/admin-dashboard" element={<AdminDashboard/>} />
                    <Route path="/admin-dashboard/activityForm" element={<ActivitiesForm/>} />
                    <Route path="/admin-dashboard/healthRecords" element={<HealthRecordsForm/>} />
                    <Route path="/admin-dashboard/nutritionDiary" element={<NutritionDiaryForm/>} />
                </Routes>
            </Router>
        </UserContext.Provider>
    );
}

export default App;
