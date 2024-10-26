<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Question</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Light background color */
        }
        .container {
            max-width: 600px; /* Set max width for the container */
            margin-top: 50px; /* Top margin for spacing */
            padding: 20px; /* Padding for the container */
            background-color: #ffffff; /* White background for the form */
            border: 1px solid #ced4da; /* Light gray border */
            border-radius: 8px; /* Rounded corners for the container */
            box-shadow: 0 4px 8px rgba(0,0,0,0.1); /* Shadow for a lifted effect */
        }
        h2 {
            margin-bottom: 20px; /* Bottom margin for the heading */
        }
        .btn {
            border-radius: 5px; /* Rounded corners for buttons */
        }
        .form-group {
            margin-bottom: 20px; /* Space between form groups */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Edit Question</h2>
        <form action="/questions/update/${question.id}" method="post">
            <div class="form-group">
                <label for="questionText">Question Text</label>
                <input type="text" class="form-control" id="questionText" name="questionText" value="${question.questionText}" required>
            </div>
            <div class="form-group">
                <label for="topic">Topic</label>
                <input type="text" class="form-control" id="topic" name="topic" value="${question.topic}" required>
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <select class="form-control" id="status" name="status" required>
                    <option value="ACTIVE" <c:if test="${question.status == 'ACTIVE'}">selected</c:if>>ACTIVE</option>
                    <option value="CLOSED" <c:if test="${question.status == 'CLOSED'}">selected</c:if>>CLOSED</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Update</button>
            <a href="/questions" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
