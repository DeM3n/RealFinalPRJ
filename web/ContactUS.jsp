<%-- 
    Document   : ContactUS
    Created on : Mar 5, 2025, 1:37:30 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sisyphus-Contact Us</title>
    </head>
    <style>
      .container {
    width: 80%;
    margin: 0 auto;
}
 .container h2 {
   text-align: center
}
.contact-section {
    display: flex;
    justify-content: space-between;
    align-items: center;
    gap: 20px;
}

.contact-img {
    flex: 1;
}
.contact-info i {
    font-size: 22px; /* Adjust the size as needed */
    margin-right: 8px; /* Add spacing between the icon and text */
    vertical-align: middle;
}
.contact-img img {
    width: 100%;
    max-width: 400px;
    border-radius: 10px;
}

.contact-info {
    flex: 1;
    font-size: 18px;
}
.contact-info p {
    position: relative;
    padding-bottom: 10px;
    margin-bottom: 10px;
    font-size: 18px; /* Adjust the size if needed */
    display: flex;
    align-items: center;
}
.contact-info p:not(:last-child)::after {
    content: "";
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 1px;
    background-color: #ddd; /* Light grey line */
}

.map {
    margin-top: 30px;
}

.map iframe {
    width: 100%;
    height: 400px;
    border: none;
}
    </style>
     <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <body>
          <%@include file="header.jsp"%>
         <div class="container">
        <h2>Contact Us</h2>
        <div class="contact-section">
            <div class="contact-img">
                <img src="img/ContactUs.jpg" alt="Hotel Sisyphus">
            </div>
            <div class="contact-info">
                <p> <i class='bx bx-current-location'></i><strong>Address:</strong> Mount Kyllini, Peloponnese, Greece</p>
                <p><i class='bx bx-globe'></i><strong>Website: </strong> SisyphusParadise.gr</p>
                <p> <i class='bx bx-phone-call'></i><strong>Phone:</strong> +30 123 456 7890</p>
                <p> <i class='bx bxs-envelope' ></i><strong>Email:</strong> support@SisyphusParadise.gr</p>
            </div>
        </div>

        <div class="map">
            <h2>Our Location</h2>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3150.123456789012!2d25.720000!3d35.262000!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zMzXCsDE1JzQzLjIiTiAyNcKwNDMnMTIuMCJF!5e0!3m2!1sen!2sus!4v1234567890123!5m2!1sen!2sus" allowfullscreen="" loading="lazy"></iframe>
        </div>
    </div>
           <%@include file="footer.jsp"%>
    </body>
</html>
