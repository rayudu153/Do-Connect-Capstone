<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f0f8ff; /* Light background color for better contrast */
        }
        .header-bg {
            background-color: #007bff; /* Bootstrap primary color */
        }
        .welcome-text {
            color: #ffffff; /* White text for better visibility */
        }
        .btn-custom {
            background-color: #28a745; /* Custom green button color */
            border: none;
        }
        .btn-custom:hover {
            background-color: #218838; /* Darker green on hover */
        }
        .btn-danger-outline {
            border: 1px solid #dc3545; /* Outline for danger button */
            color: #dc3545; /* Danger color text */
        }
        .btn-danger-outline:hover {
            background-color: #dc3545; /* Danger color on hover */
            color: white; /* White text on hover */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header header-bg text-center">
                <h2 class="welcome-text">Welcome, ${user.firstName}!</h2>
            </div>
            <div class="card-body text-center">
                <p class="lead">Manage your questions and activities from here.</p>
                <div class="d-flex justify-content-center mt-4">
                    <a href="/questions" class="btn btn-custom btn-lg mx-2">Manage Questions</a>
                </div>
                <div class="mt-4">
                    <a href="/logout" class="btn btn-danger-outline btn-sm">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
