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

    </style>
     <link rel="stylesheet" href="css/AboutUs.css">
     <link href="https://fonts.googleapis.com/css2?family=Cinzel+Decorative&display=swap" rel="stylesheet">
    </head>
    <body>
         <%@include file="header.jsp"%>
         <div class="container">
        <div class="left">
            <img src="img/JoJoRef.jpg" class="active" alt="Luxury Hotel 1">
            <img src="img/HistoryHotel.jpg" alt="Luxury Hotel 2">
            <img src="img/HotelFounder.png" alt="Luxury Hotel 3">
            <img src="img/HotelHistory.jpg" alt="Luxury Hotel 4">
            <img src="img/HistoryLobby.jpg" alt="Luxury Hotel 5">
        </div>
        <div class="right">
            <div class="content">
                <h1 style="font-family: 'Cinzel Decorative', serif;" >Our history</h1>
                <p style="font-family: 'Cinzel Decorative', serif;">In 1943, during the Nazi occupation of Greece, a German patrol stumbled upon a hidden cave in the Peloponnese. Inside, they found three ancient statues depicting Sisyphus in moments of determination, despair, and acceptance. The soldiers, initially dismissive, were soon captivated by the statues' haunting beauty. Word of the discovery reached their commanding officer, who saw them as a potential propaganda tool to glorify the Reich's supposed cultural superiority.</p>
                 <p style="font-family: 'Cinzel Decorative', serif;">Greek archaeologist Jorios Jovanakis, who had been secretly tracking Nazi looting of antiquities, learned of the statues. Risking his life, he infiltrated the camp where the statues were stored. Using his knowledge of the cave's inscriptions, he convinced the officer that the statues were cursed, bringing misfortune to those who removed them. Superstitious and unnerved, the Nazis abandoned the statues, leaving them in Jorios' care.</p>
                 <p style="font-family: 'Cinzel Decorative', serif;">Today, the Hotel Sisyphus stands as a testament to perseverance, its story intertwined with the myth of Sisyphus and the resilience of the human spirit. The statues, once nearly lost to history, continue to inspire visitors, reminding them that even in the darkest times, there is strength in enduring life's challenges.</p>
            </div>
        </div>
    </div>
  <%@include file="footer.jsp"%>
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
