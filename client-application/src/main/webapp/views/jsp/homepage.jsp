<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to DoConnect</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e9ecef; /* Changed background color */
            font-family: 'Roboto', sans-serif;
        }
        header {
            background: linear-gradient(90deg, rgba(255,99,71,1) 0%, rgba(255,140,0,1) 100%); /* Changed header gradient colors */
            color: white;
            padding: 50px 0;
        }
        header h1 {
            font-weight: 700;
        }
        .btn-primary {
            background-color: #ff6347; /* Changed primary button color */
            border: none;
            border-radius: 50px;
        }
        .btn-primary:hover {
            background-color: #e55347; /* Darker shade for hover */
        }
        .btn-success {
            background-color: #28a745; /* Changed success button color */
            border-radius: 50px;
        }
        .btn-success:hover {
            background-color: #218838; /* Darker shade for hover */
        }
        footer {
            background-color: #343a40; /* Changed footer color */
            color: white;
        }
    </style>
</head>
<body class="d-flex flex-column min-vh-100">
    <header class="text-center">
        <h1>Discover DoConnect</h1>
    </header>

    <div class="container my-5">
        <section class="mb-5 text-center">
            <h2 class="mb-4">Welcome to DoConnect</h2>
            <p class="lead">DoConnect is a dynamic Q&A platform designed to facilitate the sharing of knowledge and insights. Whether you're looking for answers to your queries or eager to help others, DoConnect provides a space for curiosity and learning.</p>
        </section>

        <section class="text-center mt-5">
            <h2>Join Us Today</h2>
            <a href="/login" class="btn btn-primary btn-lg mx-3">Sign In</a>
            <a href="/register" class="btn btn-success btn-lg mx-3">Create Account</a>
        </section>
    </div>

    <footer class="mt-auto text-center py-3">
        <p>&copy; 2024 DoConnect. Your gateway to knowledge sharing.</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
