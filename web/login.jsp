<%-- 
    Document   : login
    Created on : Feb 14, 2025, 8:27:14 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login form</title>
        <link rel="stylesheet" href="css/styles.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        
    </head>
    <body>
            <%@include file="header.jsp"%>
        <div class="container">
            <div class="loginpage">
                <form action="MainController" method="post">
                    <input type="hidden" name="action"value="login"/>
                    <h2>Login</h2>
                    <div class="input-box"> 
                        <input type="text" placeholder="Username" name="txtUsername" required />
                        <i class='bx bxs-user'></i>
                    </div>
                    <div class="input-box">
                        <input type="password" placeholder="Password" name="txtPassword" required />
                        <i class='bx bxs-lock' ></i>
                         
                    </div>
                    <div class="remember-forget">
                        <label>  <input type="checkbox"/>Remember me</label>
                        <a href="ResetPW.jsp">Forgot Password?</a>
                    </div>
                    <button type="submit" class="button">Log in</button>
                    <div class="register-link">
                        <p>Don't have an account?
                            <a href="register.jsp">Register</a> </p> 
                    </div>
                    <p style="text-align: center; color: red">  <%String message = request.getAttribute("message")+""; %>
                        <%= message.equals("null")?"":message %> </p>
                </form>
            </div>
        </div>
       
    </body>
</html>