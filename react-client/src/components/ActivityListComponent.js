import React, { useState, useEffect } from 'react';
import "../styles/ActivityListComponent.css"

function ActivitiesList() {
    const [activities, setActivities] = useState([]);
    const userId = localStorage.getItem("userId");

    useEffect(() => {
        const fetchActivities = async () => {
            try {
                let response = await fetch(`http://localhost:8080/api/activities/user/${userId}`);
                const responseBody = await response.text();
                let data = JSON.parse(responseBody);
                setActivities(data);
            } catch (error) {
                console.error('Error fetching data: ', error);
            }
        };
        fetchActivities().then(r => console.log());
    }, [userId]);

    return (
        <div>
            <h1>Activities</h1>
            <table>
                <thead>
                <tr>
                    <th>Activity Type</th>
                    <th>Time</th>
                    <th>Distance</th>
                    <th>Date</th>
                </tr>
                </thead>
                <tbody>
                {activities.map((activity, index) => (
                    <tr key={activity.activityId}>
                        <td>{activity.activityType}</td>
                        <td>{activity.duration}</td>
                        <td>{activity.distance}</td>
                        <td>{activity.activityDate}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default ActivitiesList;
