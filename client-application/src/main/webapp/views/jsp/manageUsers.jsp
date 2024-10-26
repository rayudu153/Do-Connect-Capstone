<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <div class="container mt-4">
        <div class="bg-teal text-white text-center py-3 rounded">
            <h2>Manage Users</h2>
        </div>
        
        <!-- Create User button positioned to touch the header -->
        <div class="d-flex justify-content-end mb-0">
            <a href="/users/create" class="btn btn-success mt-2">Create User</a>
        </div>
        
        <table class="table table-bordered mt-4">
            <thead class="bg-teal text-white">
                <tr>
                    <th>ID</th>
                    <th>User Name</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.role}</td>
                        <td class="text-center">
                            <div class="d-flex justify-content-center">
                                <a href="/users/edit/${user.id}" class="btn btn-warning mx-1">Edit</a>
                                <a href="/users/view/${user.id}" class="btn btn-info mx-1">View</a>
                                <a href="/users/delete/${user.id}" class="btn btn-danger mx-1" onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="d-flex justify-content-end">
            <a href="/adminHome" class="btn btn-outline-secondary btn-sm">Back to Dashboard</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <style>
        .bg-teal {
            background-color: #007b5f !important; /* Teal background color */
        }
    </style>
</body>
</html>
