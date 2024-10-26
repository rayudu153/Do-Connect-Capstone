<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f0f4f8; /* Light background color */
        }
        .header {
            background-color: #28a745; /* Thick green header */
            color: #ffffff; /* White text */
            text-align: center; /* Centered text */
            padding: 20px; /* Increased padding */
            border-radius: 8px 8px 0 0; /* Rounded top corners */
        }
        .card {
            border: none; /* Remove border */
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); /* Soft shadow */
        }
        .form-group label {
            font-weight: 600; /* Bolder label text */
        }
        .btn-primary {
            background-color: #007bff; /* Blue for create user button */
            border: none;
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transition */
        }
        .btn-primary:hover {
            background-color: #0056b3; /* Darker blue on hover */
            transform: translateY(-2px); /* Lift effect on hover */
        }
        .btn-outline-secondary {
            border-radius: 5px; /* Rounded corners */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="header">
            <h2>Create User</h2>
        </div>

        <div class="card mt-4 mx-auto" style="max-width: 500px;">
            <div class="card-body">
                <form action="/users/create" method="post">
                    <div class="form-group">
                        <label for="firstName">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required>
                    </div>
                    <div class="form-group">
                        <label for="username">User Name</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <label for="role">Role</label>
                        <select class="form-control" id="role" name="role" required>
                            <option value="" disabled selected>Select your role</option>
                            <option value="ADMIN">Admin</option>
                            <option value="USER">User</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary float-right">Create User</button>
                </form>
            </div>
        </div>

        <div class="p-3 mt-4 float-right">
            <a href="/users" class="btn btn-outline-secondary">Back</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
