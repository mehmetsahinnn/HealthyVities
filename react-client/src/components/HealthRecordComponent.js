import React, {useEffect, useState} from "react";

function HealthRecordComponent() {
    const [healthRecords, setHealthRecord] = useState([]);
    const userId = localStorage.getItem("userId");

    useEffect(() => {
        fetch(`http://localhost:8080/api/healthrecords/${userId}`)
            .then(response => response.json())
            .then(data => setHealthRecord(data))
            .catch(err => {
                console.log("Error is : " + err)
            })
    }, [userId]);

    return (
        <div>
            <h1>Health Records</h1>
            <table>
                <thead>
                <tr>
                    <th>Blood Pressure</th>
                    <th>Blood Sugar</th>
                    <th>Heart Rate</th>
                    <th>Record Date</th>
                </tr>
                </thead>
                <tbody>
                {healthRecords.map((hr, index) => (
                        <tr>
                            <td>{hr.bloodPressure}</td>
                            <td>{hr.bloodSugar}</td>
                            <td>{hr.heartRate}</td>
                            <td>{hr.recordDate}</td>
                        </tr>
                    )
                )}
                </tbody>
            </table>
        </div>
    )

}

export default HealthRecordComponent;