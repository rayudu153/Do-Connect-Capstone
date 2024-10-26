<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Light background color */
            font-family: 'Arial', sans-serif;
        }
        .header {
            background-color: #d9534f; /* Vibrant red header */
            padding: 30px; /* Thicker padding for header */
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
            margin-bottom: 30px;
        }
        .header h2 {
            color: #ffffff; /* White text for the header */
            margin: 0;
            font-weight: bold; /* Bold header text */
        }
        .btn {
            padding: 15px 30px; /* Increased padding for buttons */
            font-size: 16px;
            border-radius: 8px; /* More rounded corners */
            margin: 10px;
            transition: background-color 0.3s, transform 0.3s;
            color: white; /* White text for buttons */
        }
        .btn-manage-users {
            background-color: #5bc0de; /* Light cyan button for Manage Users */
        }
        .btn-manage-users:hover {
            background-color: #31b0d5; /* Darker cyan on hover */
            transform: translateY(-2px);
        }
        .btn-manage-questions {
            background-color: #5cb85c; /* Light green button for Manage Questions */
        }
        .btn-manage-questions:hover {
            background-color: #4cae4c; /* Darker green on hover */
            transform: translateY(-2px);
        }
        .logout-btn {
            background-color: #d9534f; /* Red for Logout */
            border: none;
            margin-top: 20px;
            padding: 10px 20px;
        }
        .logout-btn:hover {
            background-color: #c9302c; /* Darker red on hover */
        }
        .button-container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            margin-top: 40px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="header">
            <h2>Admin Dashboard</h2>
        </div>

        <div class="button-container">
            <a href="/users" class="btn btn-manage-users"><i class="fas fa-users"></i> Manage Users</a>
            <a href="/questions" class="btn btn-manage-questions"><i class="fas fa-question-circle"></i> Manage Questions</a>
        </div>

        <div class="text-right mt-4">
            <a href="/logout" class="btn logout-btn">Logout</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
