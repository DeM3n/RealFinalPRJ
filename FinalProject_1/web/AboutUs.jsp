<%-- 
    Document   : AboutUs
    Created on : Feb 28, 2025, 9:52:39 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: Arial, sans-serif; }
        .container { display: flex; height: 100vh; }
        .left { width: 50%; position: relative; overflow: hidden; }
        .left img { width: 100%; height: 100vh; object-fit: cover; position: absolute; opacity: 0; transition: opacity 1s; }
        .left img.active { opacity: 1; }
        .right { width: 50%; display: flex; justify-content: center; align-items: center; padding: 40px; background: #f8f8f8; }
        .content { max-width: 500px; text-align: justify; }
        h1 { font-size: 36px; color: #333; margin-bottom: 20px; }
        p { font-size: 18px; color: #666; }
    </style>
    </head>
    <body>
         <div class="container">
        <div class="left">
            <img src="img1.jpg" class="active" alt="Luxury Hotel 1">
            <img src="img2.jpg" alt="Luxury Hotel 2">
            <img src="img3.jpg" alt="Luxury Hotel 3">
            <img src="img4.jpg" alt="Luxury Hotel 4">
            <img src="img5.jpg" alt="Luxury Hotel 5">
        </div>
        <div class="right">
            <div class="content">
                <h1>Welcome to Our Luxury Hotel</h1>
                <p>Experience the pinnacle of elegance and comfort at our five-star luxury hotel. Nestled in the heart of the city, our hotel offers world-class accommodations, gourmet dining, and unparalleled service. Whether you are here for business or leisure, indulge in a sanctuary of sophistication where every moment is crafted to perfection.</p>
            </div>
        </div>
    </div>

    <script>
        let index = 0;
        const images = document.querySelectorAll(".left img");
        function switchImage() {
            images.forEach(img => img.classList.remove("active"));
            index = (index + 1) % images.length;
            images[index].classList.add("active");
        }
        setInterval(switchImage, 3000);
    </script>
    </body>
</html>
