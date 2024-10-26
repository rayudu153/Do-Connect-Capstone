<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Answer Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f0f4f8; /* Light background color */
            font-family: 'Roboto', sans-serif;
        }
        h2 {
            color: #343a40; /* Darker text color */
            margin-bottom: 20px; /* Space below heading */
        }
        .btn-success {
            background-color: #28a745; /* Green button */
            border: none;
            transition: background-color 0.3s; /* Smooth transition */
        }
        .btn-success:hover {
            background-color: #218838; /* Darker green on hover */
        }
        .table {
            background-color: #ffffff; /* White table background */
            border-radius: 5px; /* Rounded corners */
            overflow: hidden; /* Clip the corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Shadow effect */
        }
        .table thead {
            background: linear-gradient(90deg, rgba(108,99,255,1) 0%, rgba(86,204,242,1) 100%); /* Header gradient */
            color: white; /* White text for header */
        }
        .table th, .table td {
            vertical-align: middle; /* Center content vertically */
        }
        .btn-info, .btn-warning, .btn-danger {
            transition: background-color 0.3s; /* Smooth transition for buttons */
        }
        .btn-info:hover {
            background-color: #138496; /* Darker blue on hover */
        }
        .btn-warning:hover {
            background-color: #e0a800; /* Darker yellow on hover */
        }
        .btn-danger:hover {
            background-color: #c82333; /* Darker red on hover */
        }
        .btn-outline-secondary {
            border-radius: 50px; /* Rounded outline button */
        }
        .p-3.float-right {
            margin-top: 20px; /* Space above return button */
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Manage Answers</h2>
        <div class="text-right mb-3">
            <a href="/answers/create" class="btn btn-success">Add New Answer</a>
        </div>
        <table class="table table-hover table-bordered">
            <thead class="thead-light">
                <tr>
                    <th>Answer ID</th>
                    <th>User ID</th>
                    <th>Question ID</th>
                    <th>Answer Text</th>
                    <th>Approved</th>
                    <th>Likes Count</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="answer" items="${answers}">
                    <tr>
                        <td>${answer.answerId}</td>
                        <td>${answer.userId}</td>
                        <td>${answer.question.id}</td>
                        <td>${answer.answerText}</td>
                        <td>${answer.approved ? 'Yes' : 'No'}</td>
                        <td>${answer.likesCount}</td>
                        <td>
                            <a href="/answers/view/${answer.answerId}" class="btn btn-info btn-sm">Details</a>
                            <a href="/answers/edit/${answer.answerId}" class="btn btn-warning btn-sm">Modify</a>
                            <a href="/answers/delete/${answer.answerId}" class="btn btn-danger btn-sm">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="p-3 float-right">
            <a href="/adminHome" class="btn btn-outline-secondary btn-sm">Return to Dashboard</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
