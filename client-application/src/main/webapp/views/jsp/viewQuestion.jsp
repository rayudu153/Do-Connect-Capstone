<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Question</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom styles for card */
        .card {
            margin-top: 20px; /* Space above the card */
        }
    </style>
</head>
<body class="bg-light">
    <div class="container mt-4">
        <h2 class="text-center">View Question</h2>
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h4 class="mb-0">${question.questionText}</h4>
            </div>
            <div class="card-body">
                <p><strong>User ID:</strong> ${question.userId}</p>
                <p><strong>Topic:</strong> ${question.topic}</p>
                <p><strong>Status:</strong> ${question.status}</p>
            </div>
            <div class="card-footer text-right">
                <a href="/questions" class="btn btn-secondary">Back</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
