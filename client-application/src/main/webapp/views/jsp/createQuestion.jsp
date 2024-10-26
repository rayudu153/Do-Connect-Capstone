<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Question</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f4f8; /* Light background color */
        }
        .container {
            background: #ffffff;
            padding: 30px; /* Increased padding */
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
            max-width: 800px;
            margin-top: 50px;
        }
        h1 {
            font-size: 2rem; /* Larger header text */
            font-weight: 700; /* Bold font */
            margin-bottom: 30px;
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
        .btn-success {
            background-color: #28a745; /* Green for submit button */
            border: none;
            border-radius: 5px; /* Rounded corners for buttons */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transition for hover effect */
        }
        .btn-success:hover {
            background-color: #218838; /* Darker green on hover */
            transform: translateY(-2px); /* Lift effect on hover */
        }
        .btn-danger {
            background-color: #dc3545; /* Red for cancel button */
            border: none;
            border-radius: 5px; /* Rounded corners for buttons */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transition for hover effect */
        }
        .btn-danger:hover {
            background-color: #c82333; /* Darker red on hover */
            transform: translateY(-2px); /* Lift effect on hover */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1>Create a New Question</h1>
        <form action="/questions/create" method="post">
            <div class="form-group">
                <label for="questionText">Question Text</label>
                <textarea class="form-control" id="questionText" name="questionText" required></textarea>
            </div>
            <div class="form-group">
                <label for="topic">Topic</label>
                <input type="text" class="form-control" id="topic" name="topic">
            </div>
            <div class="form-group">
                <label for="approved">Approved</label>
                <select class="form-control" id="approved" name="approved">
                    <option value="false">No</option>
                    <option value="true">Yes</option>
                </select>
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <select class="form-control" id="status" name="status">
                    <option value="ACTIVE">Active</option>
                    <option value="CLOSED">Closed</option>
                </select>
            </div>
            <button type="submit" class="btn btn-success">Submit</button>
            <a href="/questions" class="btn btn-danger">Cancel</a>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
