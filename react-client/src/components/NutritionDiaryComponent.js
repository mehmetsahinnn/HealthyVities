import React, {useEffect, useState} from "react";
import "../styles/NutritionDiary.css"

function NutritionDiaryComponent() {

    const [nutrition, setNutrition] = useState([]);
    const userId = localStorage.getItem("userId");

    useEffect(() => {
        if (userId) {
            fetch(`http://localhost:8080/api/nutrition/${userId}`)
                .then(response => response.json())
                .then(data => setNutrition(data))
                .catch((err) => {
                    console.log("Error is : " + err);
                });
        }
    }, [userId]);

    return (
        <div>
            <h1>Nutrition Diary</h1>
            <table>
                <thead>
                <tr>
                    <th>Meal</th>
                    <th>Calories</th>
                    <th>Nutrition Details</th>
                    <th>Entry Date</th>
                </tr>
                </thead>
                <tbody>
                {nutrition.map((entry) => (
                    <tr key={entry.entryId}>
                        <td>{entry.meal}</td>
                        <td>{entry.calories}</td>
                        <td>{entry.nutritionDetails}</td>
                        <td>{new Date(entry.entryDate).toLocaleDateString()}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );

}

export default NutritionDiaryComponent;