<%-- 
    Document   : register
    Created on : Feb 14, 2025, 2:20:18 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
         <link rel="stylesheet" href="css/styles.css">
           <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <div  class="container">
        <div class="loginpage">
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="register"/>
            <h2>Register</h2>
            <div class="input-box"> 
                <input type="email" placeholder="Gmail" name="txtGmail" required=""/>
                <i class='bx bxl-gmail'></i>
            </div>
             
              <div class="input-box"> 
                <input type="text" placeholder="FullName" name="txtFullName" required=""/>
                <i class='bx bx-face'></i>
            </div>
             <div class="input-box"> 
                <input type="text" placeholder="Username"  name="txtUsername" required />
                 <i class='bx bxs-user'></i>
                </div>
                <div class="input-box">
                <input type="password" placeholder="Password" name="txtPassword" required />
            <i class='bx bx-low-vision'></i>
                </div>
             <div class="input-box">
                <input type="password" placeholder="Confirm Password" required />
            <i class='bx bx-low-vision'></i>
                </div>
              <button type="submit" class="button">Submit</button>
               <div class="register-link">
                     <p>Already have an account?
                         <a href="login.jsp">Sign in</a> </p> 
                </div>
        </form>
        </div>
        </div>
    </body>
</html>
