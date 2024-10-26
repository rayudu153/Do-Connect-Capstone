<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Light background color */
        }
        .card {
            margin-top: 30px; /* Spacing for card */
        }
        .btn {
            border-radius: 5px; /* Rounded corners for buttons */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="bg-primary text-white text-center py-3 rounded">
            <h2>Edit User</h2>
        </div>

        <div class="card mx-auto" style="max-width: 500px;">
            <div class="card-body">
                <form action="/users/update/${user.id}" method="post">
                    <div class="form-group">
                        <label for="firstName">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" value="${user.firstName}" required>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" value="${user.lastName}" required>
                    </div>
                    <div class="form-group">
                        <label for="username">User Name</label>
                        <input type="text" class="form-control" id="username" name="username" value="${user.username}" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
                    </div>
                    <div class="form-group">
                        <label for="role">Role</label>
                        <select class="form-control" id="role" name="role" required>
                            <option value="" disabled>Select your role</option>
                            <option value="ADMIN" <c:if test="${user.role == 'ADMIN'}">selected</c:if>>Admin</option>
                            <option value="USER" <c:if test="${user.role == 'USER'}">selected</c:if>>User</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary float-right">Update User</button>
                </form>
            </div>
        </div>

        <div class="p-3 mt-4">
            <a href="/users" class="btn btn-outline-secondary">Back</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
