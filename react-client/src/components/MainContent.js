import React from 'react';
import "../styles/MainContent.css";
import ActivitiesList from "./ActivityListComponent";
import HealthRecordComponent from "./HealthRecordComponent";
import NutritionDiaryComponent from "./NutritionDiaryComponent";


function MainContent() {
    return (
        <div className="html">
        <main className="main-content">
            <div className="tables-container">
                <div className="table-wrapper">
                    <ActivitiesList/>
                </div>
                <div className="table-wrapper">
                    <HealthRecordComponent/>
                </div>
                <div className="table-wrapper">
                    <NutritionDiaryComponent/>
                </div>
            </div>
        </main>
        </div>
    );
}


export default MainContent;
