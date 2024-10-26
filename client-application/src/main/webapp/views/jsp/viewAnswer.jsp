<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Answers for Question</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f2f5; /* Light background for a fresh look */
        }
        .container {
            background-color: #ffffff; /* White background for the container */
            border-radius: 8px; /* Rounded corners for the container */
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1); /* Subtle shadow effect */
            padding: 20px; /* Padding for the container */
            max-width: 800px; /* Limit the max width of the container */
            margin-top: 30px; /* Top margin for spacing */
        }
        h1 {
            font-weight: 700; /* Bold font weight */
            color: #343a40; /* Dark gray for better contrast */
        }
        h2 {
            color: #0056b3; /* Blue color for the subheading */
            border-bottom: 2px solid #0056b3; /* Underline effect */
            padding-bottom: 10px; /* Padding below the heading */
        }
        th, td {
            padding: 15px; /* Increased padding for better readability */
        }
        .btn-custom {
            transition: background-color 0.3s ease; /* Smooth transition for buttons */
            border-radius: 20px; /* Rounded buttons */
        }
        .btn-custom:hover {
            background-color: #004085; /* Darker blue for button hover effect */
            color: white; /* Change text color on hover */
        }
        .table th {
            background-color: #007bff; /* Blue background for table header */
            color: white; /* White text for header */
        }
        .table tbody tr:hover {
            background-color: #e9ecef; /* Light gray on row hover */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Question: <c:out value="${question.questionText}"/></h1>

        <h2 class="mb-3">Answers:</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Answer ID</th>
                    <th>Answer Text</th>
                    <th>Likes Count</th>
                    <th>Question ID</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${empty answers}">
                        <tr>
                            <td colspan="5" class="text-center">No answers available for this question.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="answer" items="${answers}">
                            <tr>
                                <td><c:out value="${answer.id}"/></td>
                                <td><c:out value="${answer.answerText}"/></td>
                                <td><c:out value="${answer.likesCount}"/></td>
                                <td><c:out value="${question.id}"/></td>
                                <td>
                                    <a href="<c:url value='/answers/edit/${answer.id}'/>" class="btn btn-warning btn-sm btn-custom">Edit</a>
                                    <a href="<c:url value='/answers/delete/${answer.id}'/>" class="btn btn-danger btn-sm btn-custom" 
                                       onclick="return confirm('Are you sure you want to delete this answer?');" 
                                       aria-label="Delete answer ${answer.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>

        <div class="mt-3">
            <a href="<c:url value='/answers/create/${question.id}'/>" class="btn btn-success btn-custom">Add New Answer</a>
            <a href="<c:url value='/questions'/>" class="btn btn-secondary btn-custom">Back to Questions</a>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
