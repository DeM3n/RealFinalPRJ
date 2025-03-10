<%-- 
    Document   : Home
    Created on : Feb 28, 2025, 12:54:56 PM
    Author     : HP
--%>

<%@page import="dto.RoomTypeDTO"%>
<%@page import="java.util.List"%>
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
    <% UserDTO user = (UserDTO) session.getAttribute("user");
    List<RoomTypeDTO> roomTypes =(List<RoomTypeDTO>) request.getAttribute("roomTypes"); %>

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
             <div class="slider-container">
        <div class="slides">
            <div class="slide active">
                <img src="img/LuxuryRoom.jpg" alt="Room Service">
                <div class="caption">24/7 Room Service</div>
            </div>
            <div class="slide">
                <img src="img/spa.png" alt="Spa Treatment">
                <div class="caption">Relaxing Spa Treatments</div>
            </div>
            <div class="slide">
                <img src="img/City.jpg" alt="City Tour">
                <div class="caption">Guided City Tours</div>
            </div>
             <div class="slide">
                <img src="img/Concert.jpg" alt="Musical Concert">
                <div class="caption">Musical Concert</div>
            </div>
             <div class="slide">
                <img src="img/ThemePark.jpg" alt="Theme Park">
                <div class="caption">Theme Park</div>
            </div>
        </div>
        <button class="prev" onclick="prevSlide()">&#10094;</button>
        <button class="next" onclick="nextSlide()">&#10095;</button>
    </div>

    <div class="dots">
       <ul class="dots">
    <li class="dot active" onclick="setSlide(0)"></li>
    <li class="dot" onclick="setSlide(1)"></li>
    <li class="dot" onclick="setSlide(2)"></li>
    <li class="dot" onclick="setSlide(3)"></li>
    <li class="dot" onclick="setSlide(4)"></li>
</ul>
    </div>
        </div>

     
        <%@include file="footer.jsp"%>
    </div>
    <div class="overlay" id="overlay" onclick="closePopup()"></div>
    <!-- Booking Pop-up -->
     <div class="popup" id="popup" style="display: none;">
        <h2>Book Your Stay</h2>
        <form id="bookingForm" action="MainController" method="post">
            <input type="hidden" name="action" value="booknow" />
            <label for="checkin">Check-in Date:</label>
            <input type="date" id="checkin" name="txtCheckIn" required>

            <label for="checkout">Check-out Date:</label>
            <input type="date" id="checkout" name="txtCheckOut" required>
         <% if (roomTypes != null) { %>
            <label for="roomType">Room Type:</label>
            <select name="txtRoomType"id="roomType" required onchange="updateDescription()">
                <% for (RoomTypeDTO r : roomTypes) {
                %>
                <option value="<%=r.getRoomTypeID()%>"  data-description="<%= r.getDescription() %>">   
                    <%= r.getRoomTypeName() %> - $<%= r.getPricePerNight() %></option>
          
                <% }%>
            </select>
             <p id="roomDescription" style="font-style: italic; color: gray;">Select a room type to see the description</p>
            <% } else { %>
    <p style="color: red;">No room types available</p>
<% } %>

            <button type="submit" class="confirm-btn">Confirm Booking</button>
            <button type="button" class="close-btn" onclick="closePopup()">Cancel</button>
            <p style="text-align: center; color: red">  <%String message = request.getAttribute("errorMessage")+""; %>
                        <%= message.equals("null")?"":message %> </p>
        </form>
    </div>
    
    <% if (user != null) { %>
        <button type="button" class="book-now" onclick="openPopup()">Book Now</button>
    <% } else { %>
        <button type="button" class="book-now" onclick="redirectToLogin()">Book Now</button>
    <% } %>
<% Boolean showPopup = (Boolean) request.getAttribute("showPopup"); %>
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
        //-----//
          document.addEventListener("DOMContentLoaded", function() {
        <% if (showPopup != null && showPopup) { %>
            openPopup(); // Mở popup nếu có lỗi
        <% } %>
    });
       // ------//
      let slideIndex = 0;
const slides = document.querySelectorAll(".slide");
const dots = document.querySelectorAll(".dot");

function showSlide(index) {
    slides.forEach(slide => slide.classList.remove("active"));
    dots.forEach(dot => dot.classList.remove("active"));

    slideIndex = (index + slides.length) % slides.length; // Xoay vòng khi hết slide

    slides[slideIndex].classList.add("active");
    dots[slideIndex].classList.add("active");
}

function nextSlide() {
    showSlide(slideIndex + 1);
}

function prevSlide() {
    showSlide(slideIndex - 1);
}

function setSlide(index) {
    showSlide(index);
}

// Tự động chuyển slide sau 3 giây
setInterval(nextSlide, 3000);

// Hiển thị slide đầu tiên
showSlide(slideIndex);


  function updateDescription() {
        var roomSelect = document.getElementById("roomType");
        var selectedOption = roomSelect.options[roomSelect.selectedIndex];
        var description = selectedOption.getAttribute("data-description");

        document.getElementById("roomDescription").textContent = description || "No description available.";
    }

    // Gọi hàm updateDescription() ngay khi trang tải xong
    window.onload = function() {
        updateDescription();
    };
    </script>
    </body>
</html>
