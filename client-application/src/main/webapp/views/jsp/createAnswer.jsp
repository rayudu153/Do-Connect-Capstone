<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Answer</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f4f8; /* Light background color */
        }
        .container {
            background: #ffffff;
            padding: 30px; /* Increased padding for a more spacious feel */
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.2);
            max-width: 800px;
            margin-top: 50px;
        }
        h2 {
            font-size: 2rem; /* Larger header text */
            font-weight: 700; /* Bold font */
            margin-bottom: 20px;
            color: #343a40; /* Dark color for the header */
            text-align: center; /* Centered text */
            background-color: #28a745; /* Vibrant green background for header */
            padding: 20px; /* Padding for the header */
            border-radius: 8px; /* Rounded corners for header */
            color: #ffffff; /* White text for header */
        }
        .form-group {
            margin-bottom: 20px; /* Increased margin */
        }
        label {
            font-weight: 600; /* Bolder label text */
        }
        .btn-primary {
            background-color: #007bff; /* Primary button color */
            border: none;
            border-radius: 5px; /* Rounded corners for buttons */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transition for hover effect */
        }
        .btn-primary:hover {
            background-color: #0056b3; /* Darker blue on hover */
            transform: translateY(-2px); /* Lift effect on hover */
        }
        .btn-secondary {
            margin-top: 10px;
            background-color: #6c757d; /* Gray color for secondary button */
            border-radius: 5px; /* Rounded corners for buttons */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transition for hover effect */
        }
        .btn-secondary:hover {
            background-color: #5a6268; /* Darker gray on hover */
            transform: translateY(-2px); /* Lift effect on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Create Answer for Question: <em>${question.questionText}</em></h2>
        <form action="/answers/create/${question.id}" method="post">
            <input type="hidden" name="userId" value="1" />
            
            <div class="form-group">
                <label for="answerText">Your Answer:</label>
                <textarea name="answerText" id="answerText" class="form-control" rows="4" required></textarea>
            </div>
            
            <div class="form-group">
                <label for="comment">Comment (optional):</label>
                <textarea name="comment" id="comment" class="form-control" rows="3"></textarea>
            </div>
            
            <button type="submit" class="btn btn-primary">Submit Answer</button>
            <a href="/questions" class="btn btn-secondary float-right">Back to Questions</a>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
