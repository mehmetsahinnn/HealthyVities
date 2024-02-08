import React from "react";

function AdminDashboard() {
    const handleRedirect = (url) => {
        window.location.href = url;
    };

    return (
        <div className="">
            <main className="main-content">
                <div className="">

                    <div className="table-wrapper flex-content">
                        <h1>Welcome {localStorage.getItem("username")}</h1>
                        <br/>
                        <button onClick={() => handleRedirect("/admin-dashboard/activityForm")}>Add Activity</button>
                        <button onClick={() => handleRedirect("/admin-dashboard/healthRecords")}>Add Health Records
                        </button>
                        <button onClick={() => handleRedirect("/admin-dashboard/nutritionDiary")}>Add Nutrition Diary
                        </button>
                    </div>
                    <div className="table-wrapper">
                        <br/>
                        <button onClick={() => handleRedirect("/")} className="logout-button">Exit</button>
                    </div>
                </div>
            </main>
        </div>
    )
}

export default AdminDashboard;