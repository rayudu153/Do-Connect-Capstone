<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Answer</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Light background color */
        }
        .container {
            max-width: 600px; /* Set max width for the container */
            margin-top: 50px; /* Top margin for spacing */
        }
        .btn-primary {
            border-radius: 5px; /* Rounded corners */
        }
        .btn-outline-secondary {
            border-radius: 5px; /* Rounded corners */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center mb-4">Edit Answer</h2>
        <form action="/answers/update/${answer.id}" method="post">
            <div class="mb-3">
                <!-- Hidden inputs for userId and questionId -->
                <input type="hidden" name="userId" value="${answer.user.id}">
                <input type="hidden" name="questionId" value="${answer.question.id}">
            </div>

            <div class="mb-3">
                <label for="answerText" class="form-label">Answer:</label>
                <textarea name="answerText" id="answerText" class="form-control" rows="4" required>${answer.answerText}</textarea>
            </div>

            <div class="mb-3">
                <label for="likesCount" class="form-label">Likes Count:</label>
                <div class="input-group">
                    <input type="number" name="likesCount" id="likesCount" class="form-control" value="${answer.likesCount}" min="0" required>
                    <div class="input-group-append">
                        <button type="button" class="btn btn-outline-secondary" id="likeButton" onclick="toggleLike()">
                            <i class="far fa-heart" id="likeIcon"></i>
                        </button>
                    </div>
                </div>
            </div>

            <div class="mb-3 form-check">
                <input type="checkbox" name="approved" id="approved" class="form-check-input" ${answer.approved ? 'checked' : ''}>
                <label for="approved" class="form-check-label">Approved</label>
            </div>

            <div class="mb-3">
                <label for="comment" class="form-label">Comment:</label>
                <textarea name="comment" id="comment" class="form-control" rows="3">${answer.comment}</textarea>
            </div>

            <button type="submit" class="btn btn-primary">Update Answer</button>
            <a href="/answers/${answer.question.id}" class="btn btn-outline-secondary">Back to View Answers</a>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- JavaScript to handle like button -->
    <script>
        let liked = false;

        function toggleLike() {
            liked = !liked;
            const likeIcon = document.getElementById("likeIcon");
            const likesCountInput = document.getElementById("likesCount");

            if (liked) {
                likeIcon.classList.remove("far", "fa-heart");
                likeIcon.classList.add("fas", "fa-heart");
                likesCountInput.value = parseInt(likesCountInput.value) + 1; // Increment likes
            } else {
                likeIcon.classList.remove("fas", "fa-heart");
                likeIcon.classList.add("far", "fa-heart");
                likesCountInput.value = Math.max(0, parseInt(likesCountInput.value) - 1); // Decrement likes, prevent negative
            }
        }
    </script>
</body>
</html>
