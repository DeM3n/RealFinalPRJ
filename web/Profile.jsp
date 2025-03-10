<%-- 
    Document   : Profile
    Created on : Mar 6, 2025, 11:38:13 AM
    Author     : HP
--%>

<%@page import="utils.AuthUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>US Profile</title>
        <link rel="stylesheet" href="css/USprofile.css">
    </head>
    <body>
        <%@include file="header.jsp"%>
     <div class="container">
    <div class="profile-container">
        <c:set var="isLoggedIn" value="<%=AuthUtils.isLoggedIn(session) %>"/>
        <c:if test="${isLoggedIn}">
        <!-- Left Section: Profile Header -->
        <c:if test="${not empty sessionScope.user  }">
        <div class="profile-header">
            <img src="img/logo.png" alt="Company Logo" class="logo">  <!-- Add Logo Here -->
            <h2>Welcome, <span id="displayUsername">${user.fullName}</span>!</h2>
            <p>Manage your account settings here.</p>
             <p>Keep your profile updated to ensure a better experience.</p>

    <!-- Follow Us Section -->
    <div class="social-media">
    <p class="social-text">Follow Us on Social Media:</p>
    <div class="social-icons">
        <a href="https://www.facebook.com" target="_blank"><i class="fab fa-facebook"></i></a>
        <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ" target="_blank"><i class="fab fa-youtube"></i></a>
        <a href="https://www.tiktok.com" target="_blank"><i class="fab fa-tiktok"></i></a>
        <a href="https://www.instagram.com" target="_blank"><i class="fab fa-instagram"></i></a>
    </div>
</div>
            <!-- Centered Logout Button -->
            <div class="logout-wrapper">
                 <form action="MainController" method="POST">
        <input type="hidden" name="action" value="logout">
        <button class="logout-btn" type="submit">Logout</button>
    </form>
            </div>
        </div>

        <!-- Right Section: Profile Form -->
        <div class="profile-form">
            <h2>Account Details</h2>
        
   
           <form id="profileForm" action="MainController" method="post">
    <div class="profile-info">
        <label>Username:</label>
        <input type="text" name="txtUserName" id="username" value="${user.userName}" readonly>
    </div>
    <div class="profile-info">
        <label>Full Name:</label>
        <input type="text" name="txtFullName" id="fullname" value="${user.fullName}" disabled>
    </div>
    <div class="profile-info">
        <label>Email:</label>
        <input type="email" name="txtEmail" id="email" value="${user.email}" disabled>
    </div>
    <div class="profile-info">
        <label>Password:</label>
        <input type="password" name="txtPassword" id="password" disabled>
    </div>
     <div class="profile-info">
        <label>Confirm Password:</label>
        <input type="password" name="txtConfirmPassword" id="confirmPassword"  disabled>
    </div>
    <input type="hidden" name="action" value="updateProfile">

    <div class="buttons">
        <button type="button" id="editBtn" onclick="enableEdit()">Edit</button>
        <button type="submit" id="saveBtn" style="display: none;">Save</button>
        <button type="button" id="resetBtn" onclick="cancelEdit()" style="display: none;">Cancel</button>
    </div>
    <div class="message-container">
    <% if (request.getAttribute("emailError") != null) { %>
        <p style="color: red;"><%= request.getAttribute("emailError") %></p>
    <% } %>

    <% if (request.getAttribute("passwordError") != null) { %>
        <p style="color: red;"><%= request.getAttribute("passwordError") %></p>
    <% } %>

    <% if (request.getAttribute("passwordMismatch") != null) { %>
        <p style="color: red;"><%= request.getAttribute("passwordMismatch") %></p>
    <% } %>

    <% if (request.getAttribute("message") != null) { %>
        <p style="color: green;"><%= request.getAttribute("message") %></p>
    <% } %>
</div>
</form>
        </div>
        </c:if>
 </c:if>

            <c:if test="${!isLoggedIn}">
             <div class="error-message">
        <p><strong>Access Denied!</strong> You must be logged in to view this page.</p>
    </div>
                        </c:if>

    </div>
</div>
        
        <%@include file="footer.jsp"%>
        <script>
            let originalValues = {};

function enableEdit() {
    originalValues = {
        fullname: document.getElementById("fullname").value.trim(),
        email: document.getElementById("email").value.trim(),
        password: document.getElementById("password").value.trim(),
        confirmPassword: document.getElementById("confirmPassword").value.trim()
    };

    document.getElementById("fullname").disabled = false;
    document.getElementById("email").disabled = false;
    document.getElementById("password").disabled = false;
    document.getElementById("confirmPassword").disabled = false;

    document.getElementById("editBtn").style.display = "none";
    document.getElementById("saveBtn").style.display = "inline-block";
    document.getElementById("resetBtn").style.display = "inline-block";
}

function cancelEdit() {
    document.getElementById("fullname").value = originalValues.fullname;
    document.getElementById("email").value = originalValues.email;
    document.getElementById("password").value = originalValues.password;
    document.getElementById("confirmPassword").value = originalValues.confirmPassword;

    document.getElementById("fullname").disabled = true;
    document.getElementById("email").disabled = true;
    document.getElementById("password").disabled = true;
    document.getElementById("confirmPassword").disabled = true;

    document.getElementById("editBtn").style.display = "inline-block";
    document.getElementById("saveBtn").style.display = "none";
    document.getElementById("resetBtn").style.display = "none";
}

document.getElementById("profileForm").addEventListener("submit", function(event) {
    document.querySelectorAll("#profileForm input").forEach(input => {
        if (input.disabled) {
            input.removeAttribute("name"); // Chỉ xóa nếu input đang bị disable
        }
    });
});

</script>
    </body>
    
</html>
