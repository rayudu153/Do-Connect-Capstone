<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Question Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            background: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            max-width: 95%;
        }
        h1 {
            font-size: 2.5rem;
            font-weight: 700;
            color: #ffffff; /* Changed header text color to white for better visibility */
        }
        .header {
            background-color: #28a745; /* Changed to a brighter green */
            color: #ffffff;
            text-align: center;
            padding: 20px;
            border-radius: 8px 8px 0 0;
        }
        .table thead th {
            background-color: #343a40;
            color: #ffffff;
        }
        .table tbody tr:hover {
            background-color: #e9ecef;
        }
        .btn {
            margin-right: 5px;
        }
        .highlight {
            background-color: yellow; /* Highlight color */
            font-weight: bold; /* Optional for better visibility */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="header">
            <h1>Manage Questions</h1>
        </div>
        
        <!-- Add margin to create space between header and buttons -->
        <div class="d-flex justify-content-between mb-4 mt-3">
            <a href="/adminHome" class="btn btn-secondary">Back</a>
            <a href="/questions/create" class="btn btn-success">Add New Question</a>
        </div>

        <!-- Search Form -->
        <form action="/questions/search" method="get" class="mb-4">
            <div class="input-group">
                <input type="text" name="term" class="form-control" placeholder="Search questions" required>
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit">Search</button>
                </div>
            </div>
        </form>

        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>User</th>
                    <th>Question Text</th>
                    <th>Topic</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="question" items="${questions}">
                    <tr>
                        <td>${question.id}</td>
                        <td>${user.username}</td>
                        <td>${question.questionText}</td> <!-- Directly display the question text -->
                        <td>${question.topic}</td>
                        <td>${question.status}</td>
                        <td>
                            <a href="/answers/create/${question.id}" class="btn btn-primary btn-sm">Create Answer</a>
                            <a href="/answers/${question.id}" class="btn btn-info btn-sm">View Answers</a>
                            <a href="/questions/edit/${question.id}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="/questions/delete/${question.id}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
