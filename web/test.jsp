<%-- 
    Document   : test
    Created on : Mar 5, 2025, 10:39:21 AM
    Author     : HP
--%>

<%@page import="java.util.List"%>
<%@page import="dao.RoomDAO"%>
<%@page import="dto.RoomDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       <form action="MainController" method="GET">
            <input type="hidden" name="action" value="test">
            Enter Room ID: <input type="text" name="txtID" >
            <input type="submit" value="Search">

        </form>
         <form action="MainController" method="GET">
            <input type="hidden" name="action" value="test">
            Enter Room Status: <input type="text" name="txtStatus" >
            <input type="submit" value="Search">

        </form>
<!--        <%
            List<RoomDTO> rooms = (List<RoomDTO>) request.getAttribute("rooms");
            if (rooms != null && !rooms.isEmpty()) {
        %>
        <h3>Room Details:</h3>
        <table border="1">
            <tr>
                <th>Room ID</th>
                <th>Room Type ID</th>
                <th>Room Number</th>
                <th>Room Status</th>
            </tr>
            <%
                for (RoomDTO room : rooms) {
            %>
            <tr>
                <td><%= room.getRoomID()%></td>
                <td><%= room.getRoomTypeID()%></td>
                <td><%= room.getRoomNumber()%></td>
                <td><%= room.getRoomStatus()%></td>
            </tr>
            <%
                    }
                }
            %>
        </table>-->
        <!------->
        <%
            rooms = (List<RoomDTO>) request.getAttribute("rooms");
            if (rooms != null && !rooms.isEmpty()) {
        %>
        <h3>Room Details:</h3>
        <table border="1">
            <tr>
                <th>Room ID</th>
                <th>Room Type ID</th>
                <th>Room Number</th>
                <th>Room Status</th>
            </tr>
            <%
                for (RoomDTO room : rooms) {
            %>
            <tr>
                <td><%= room.getRoomID()%></td>
                <td><%= room.getRoomTypeID()%></td>
                <td><%= room.getRoomNumber()%></td>
                <td><%= room.getRoomStatus()%></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
