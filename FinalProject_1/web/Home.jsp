<%-- 
    Document   : Home
    Created on : Feb 28, 2025, 12:54:56 PM
    Author     : HP
--%>

<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/homestyle.css">
        <style>
        .popup {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: #fff;
            padding: 20px;
            width: 300px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
            display: none;
            z-index: 1000;
        }
        .overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            display: none;
            z-index: 999;
        }
        .popup h2 {
    margin-bottom: 15px;
}

.popup label {
    display: block;
    margin-top: 10px;
    font-weight: bold;
}

.popup input,
.popup select {
    width: 100%;
    padding: 8px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

/* Buttons */
.confirm-btn, .close-btn {
    margin-top: 15px;
    padding: 10px;
    width: 100%;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

.confirm-btn {
    background-color: #28a745;
    color: white;
}

.close-btn {
    background-color: #dc3545;
    color: white;
    margin-top: 10px;
}
    </style>
    </head>
    <body>
        <%@include file="header.jsp"%>
    <% UserDTO user = (UserDTO) session.getAttribute("user"); %>

    <% if (user != null) { %>
        <div class="welcome">
            <h1>Welcome <%= user.getFullName() %> to Our Luxurious Hotel</h1>
        </div>
    <% } %>

    <div class="container">
        <h3>Welcome to Sisyphus Hotel, a timeless destination steeped in beauty and history, 
            offering an enchanting blend of picturesque architecture, stunning interiors, and scenic views.
            Discover the rich legacy of this heritage site, where nature meets luxury in a serene getaway perfect for relaxation. Enjoy unmatched amenities, including spa services, gourmet dining, and personalized experiences.
            Plan your visit today and immerse yourself in the magic of Sisyphus for an unforgettable stay.</h3>
        <div class="gallery">
            <img src="img/hotelExterior.jpg" alt="Hotel Exterior">
            <img src="img/hotelLobby.jpg" alt="Hotel Lobby">
            <img src="img/deluxeRoom.jpg" alt="Deluxe Room">
            <img src="img/pool.jpg" alt="Swimming Pool">
        </div>

        <div class="services">
            <h2>Our Services</h2>
            <p>Experience the best hospitality with 24/7 room service, spa treatments, guided city tours, and more.</p>
        </div>

        <div class="facilities">
            <h2>Our Facilities</h2>
            <p>Enjoy our state-of-the-art fitness center, infinity pool, gourmet dining, and premium lounge.</p>
        </div>
        <%@include file="footer.jsp"%>
    </div>
    <div class="overlay" id="overlay" onclick="closePopup()"></div>
    <!-- Booking Pop-up -->
     <div class="popup" id="popup" style="display: none;">
        <h2>Book Your Stay</h2>
        <form id="bookingForm">
            <label for="checkin">Check-in Date:</label>
            <input type="date" id="checkin" required>

            <label for="checkout">Check-out Date:</label>
            <input type="date" id="checkout" required>

            <label for="roomType">Room Type:</label>
            <select id="roomType" required>
                <option value="single">Single Room</option>
                <option value="double">Double Room</option>
                <option value="suite">Suite</option>
            </select>

            <button type="submit" class="confirm-btn">Confirm Booking</button>
            <button type="button" class="close-btn" onclick="closePopup()">Cancel</button>
        </form>
    </div>
    
    <% if (user != null) { %>
        <button type="button" class="book-now" onclick="openPopup()">Book Now</button>
    <% } else { %>
        <button type="button" class="book-now" onclick="redirectToLogin()">Book Now</button>
    <% } %>

    <script>
        function openPopup() {
            document.getElementById("popup").style.display = "block";
            document.getElementById("overlay").style.display = "block";
        }

        function closePopup() {
            document.getElementById("popup").style.display = "none";
            document.getElementById("overlay").style.display = "none";
        }

        function redirectToLogin() {
            alert("You need to log in to book a room.");
            window.location.href = "login.jsp";
        }
    </script>
    </body>
</html>
