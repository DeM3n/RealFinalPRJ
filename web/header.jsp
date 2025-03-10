<%-- 
    Document   : header
    Created on : Feb 25, 2025, 12:28:13 PM
    Author     : no-solace
--%>


<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        /* Reset CSS */
        @import url('https://fonts.googleapis.com/css2?family=Nunito+Sans:ital,opsz,wght@0,6..12,200..1000;1,6..12,200..1000&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap');
        @import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Nunito", serif;
        }

        /* Body Styling */
        body {
            background-color: #FAFAFA;
            color: #2C2C2C;
            line-height: 1.8;
            font-size: 18px;
        }

        .header {
            width: 100%;
            background-color: #FFFFFF;
            height: 70px;
            padding: 10px 50px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 2px solid #DDD;
            margin-bottom: 20px;
        }

        .navtab h1 {
            align-items: center;
            border-bottom: 2px #000;
        }

        /* Logo */
        .logo {
            width: 20%;
            display: flex;
            height: 50px;

        }

        .logo img {
            height: 100%;
            border-radius: 10px;
        }

        .logo h1 {
            line-height: 20px;
            display: flex;
            align-items: center;
            justify-items: center;
            padding: 10px;
            border-left: 2px solid;
            border-color: #000;
            font-size: 20px;
            font-weight: 700;
            color: #2C2C2C;
            margin-top: 10px;
            margin-left: 10px;
            height: 30px;
        }

        /* Navigation */
        .navbar ul {
            align-items: center;
            list-style: none;
            display: flex;
            gap: 25px;
        }

        .navbar ul li a {
            text-decoration: none;
            color: #333;
            font-size: 18px;
            font-weight: 500;
            padding: 10px 15px;
            transition: 0.3s;
        }

        .navbar ul li a:hover {
            color: #000;
            border-bottom: 2px solid #333;
        }

        /* Call-to-Action Button */
        .cta {
            display: flex;
            align-items: center;
        }

        .user-section {
            height: 50px;
            width: 20%;
            justify-content: right;
            justify-items: right;
            display: flex;
            align-items: center;
        }

        .user-section .signin  {
            justify-items: center;
            align-items: center;
            padding: 10px 10px;
            font-size: 20px;
            font-weight: 700;
            background-color: transparent;
            height: 80%;
            border: none;
            margin: 10px;
            transition: 0.3s;
        }

        .user-section .signin:hover {
            color: #000;
            border-bottom: 2px solid #333;
        }

        .user-section .icon-person {
            margin-right: 10px;
        }
  /* Notification Badge */
    .notification-badge {
     background-color: red;
    color: white;
    font-size: 10px; /* Adjust font size */
    width: 16px; /* Fixed width */
    height: 16px; /* Fixed height */
    display: flex; /* Use flexbox */
    align-items: center; /* Center vertically */
    justify-content: center; /* Center horizontally */
    border-radius: 50%; /* Perfect circle */
    position: absolute;
    top: -3px;
    right: -5px;
    cursor: pointer;
    }

    /* Invoice container */
    .invoice-container {
        position: relative;
        display: inline-block;
    }

    .invoice-icon {
        font-size: 24px;
        cursor: pointer;
        position: relative;
    }

    /* Dropdown Styling */
    .invoice-dropdown {
        display: none;
        position: absolute;
        top: 40px;
        right: 0;
        background: white;
        border: 1px solid #ccc;
        border-radius: 5px;
        width: 200px;
        box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
        padding: 10px;
    }

    .invoice-dropdown h4 {
        margin: 0;
        font-size: 16px;
        text-align: center;
    }

    .invoice-dropdown ul {
        list-style: none;
        padding: 0;
        margin: 10px 0 0;
    }

    .invoice-dropdown ul li {
        padding: 8px;
        border-bottom: 1px solid #eee;
    }

    .invoice-dropdown ul li:last-child {
        border-bottom: none;
    }

    .invoice-dropdown ul li a {
        text-decoration: none;
        color: #007bff;
        display: block;
    }

    .invoice-dropdown ul li a:hover {
        background-color: #f8f9fa;
    } 
    </style>
    <head>
        <meta charset="UTF-8" />
        <title>Test</title>
      
    </head>

    <body>


       <% if (session.getAttribute("user") != null) {
    UserDTO user = (UserDTO) session.getAttribute("user");
%>


<header class="header">
    <div class="logo">
        <img src="assets/images/logo.png" alt="Hotel Logo" style="width: 50px; height: 50px">
        <h1>SISYPHUS</h1>
    </div>

    <nav class="navbar">
        <ul class="home-btn">
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="Profile.jsp">Profile</a></li>
            <li><a href="AboutUs.jsp">About Us</a></li>
            <li><a href="ContactUS.jsp">Contact</a></li>
        </ul>
    </nav>
   <div class="invoice-container">
    <div class="invoice-icon" onclick="handleInvoiceClick()">
        <i class="fas fa-file-invoice"></i>
        <span id="invoice-notification" class="notification-badge">1</span>
    </div>

    <!-- Invoice Dropdown -->
    <div id="invoice-dropdown" class="invoice-dropdown">
        <h4>Your Invoices</h4>
        <ul id="invoice-list">
            <li><a href="Invoice.jsp?id=123">Invoice #123</a></li>
            <li><a href="Invoice.jsp?id=124">Invoice #124</a></li>
            <li><a href="Invoice.jsp?id=125">Invoice #125</a></li>
        </ul>
    </div>
</div>
    <div class="user-section">
         <form action="MainController" method="post" >
              <input type="hidden" name="action" value="logout"/>
       <button class="signin" >
            <span class="fa fa-user icon-person"></span> Log out
        </button>
         </form>
    </div>

</header>

<% } else { %>
<header class="header">
    <div class="logo">
        <img src="assets/images/logo.png" alt="Hotel Logo" style="width: 50px; height: 50px">
        <h1>SISYPHUS</h1>
    </div>

    <nav class="navbar">
        <ul class="home-btn">
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="Profile.jsp">Profile</a></li>
            <li><a href="AboutUs.jsp">About Us</a></li>
            <li><a href="ContactUS.jsp">Contact</a></li>
        </ul>
    </nav>
<div class="invoice-icon">
        <i class="fas fa-file-invoice"></i>
    </div>
    <div class="user-section">
        
        <button class="signin" onclick="window.location.href = 'login.jsp'">
            <span class="fa fa-user icon-person"></span> Sign in
        </button>
    </div>

</header>
<% } %>
<script>
   function handleInvoiceClick() {
        toggleInvoiceDropdown();  // Open/Close Dropdown
        clearNotification();      // Clear the red badge
    }

    function toggleInvoiceDropdown() {
        var dropdown = document.getElementById("invoice-dropdown");
        dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
    }

    function clearNotification() {
        var notification = document.getElementById("invoice-notification");
        notification.style.display = "none"; // Hide notification badge
    }

    // Close dropdown if clicked outside
    document.addEventListener("click", function(event) {
        var dropdown = document.getElementById("invoice-dropdown");
        var icon = document.querySelector(".invoice-icon");
        if (!icon.contains(event.target) && !dropdown.contains(event.target)) {
            dropdown.style.display = "none";
        }
    });
</script>
    </body>

</html>