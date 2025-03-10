<%-- 
    Document   : AdminPage
    Created on : Mar 7, 2025, 2:31:54 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Mananger</title>
   <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .sidebar {
            position: fixed;
            right: -200px;
            top: 0;
            width: 200px;
            height: 100%;
            background: #333;
            transition: right 0.3s;
            padding-top: 50px;
        }
        .hover-area {
            position: fixed;
            right: 0;
            top: 0;
            width: 20px;
            height: 100%;
            background: transparent;
        }
        .hover-area:hover + .sidebar,
        .sidebar:hover {
            right: 0;
        }
        .sidebar a {
            display: block;
            color: white;
            padding: 10px;
            text-decoration: none;
        }
        .sidebar a:hover {
            background: #575757;
        }
        .container {
            margin: 20px;
        }
        .popup-form {
    display: none; /* Ẩn mặc định */
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: white;
    padding: 20px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    z-index: 1000;
}
        .popup-form h3 {
            margin-top: 0;
        }
        .popup-form input, .popup-form textarea {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .popup-buttons {
            display: flex;
            justify-content: flex-end;
            gap: 10px;
            margin-top: 10px;
        }
        .save-btn {
            background: #28a745;
            color: white;
            padding: 6px 12px;
            border: none;
            cursor: pointer;
        }
        .cancel-btn {
            background: #dc3545;
            color: white;
            padding: 6px 12px;
            border: none;
            cursor: pointer;
        }
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .sidebar {
            position: fixed;
            right: -200px;
            top: 0;
            width: 200px;
            height: 100%;
            background: #333;
            transition: right 0.3s;
            padding-top: 50px;
        }
        .hover-area {
            position: fixed;
            right: 0;
            top: 0;
            width: 20px;
            height: 100%;
            background: transparent;
        }
        .hover-area:hover + .sidebar,
        .sidebar:hover {
            right: 0;
        }
        .sidebar a {
            display: block;
            color: white;
            padding: 10px;
            text-decoration: none;
        }
        .sidebar a:hover {
            background: #575757;
        }
        .container {
            margin: 20px;
        }
        .entity-table {
            display: none;
        }
        table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}
th, td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: left;
}
th {
    background-color: #333;
    color: white;
}
tr:nth-child(even) {
    background-color: #f2f2f2;
}
tr:hover {
    background-color: #ddd;
}
.search-bar {
            margin-bottom: 10px;
            padding: 5px;
            width: 100%;
            box-sizing: border-box;
        }
            .menu-arrow {
            position: fixed;
            top: 50%;
            right: 20px;
            transform: translateY(-50%);
            font-size: 40px;
            color: gray;
            cursor: pointer;
            transition: transform 0.3s ease, color 0.3s ease;
        }

        /* Hiệu ứng khi di chuột vào */
        .menu-arrow:hover {
            color: black;
            transform: translateY(-50%) rotate(15deg);
        }
    </style>
</head>

      
  
<body>
     
    <div class="hover-area"></div>
    <div class="sidebar">
        <a href="#" onclick="showTable('User')">User</a>
        <a href="#" onclick="showTable('Booking')">Booking</a>
        <a href="#" onclick="showTable('Room')">Room</a>
        <a href="#" onclick="showTable('RoomType')">Room Type</a>
        <a href="#" onclick="showTable('Invoice')">Invoice</a>
    </div>

      <div class="container">
        <h2>Admin Dashboard</h2>
        <div id="tables">
           <div id="User" class="entity-table">
                <h3>Manage Users</h3>
                <div class="search-container">
                    <input type="text" class="search-bar" placeholder="Search Users..." onkeyup="searchTable(this, 'User')">
                    <button class="show-all-btn" onclick="resetSearch('User')">Show All</button>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>UserID</th>
                            <th>UserName</th>
                            <th>FullName</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>

            <!-- Booking Table -->
            <div id="Booking" class="entity-table">
                <h3>Manage Bookings</h3>
                <div class="search-container">
                    <input type="text" class="search-bar" placeholder="Search Bookings..." onkeyup="searchTable(this, 'Booking')">
                     <select class="filter-dropdown" onchange="filterStatus(this, 'Booking')">
                        <option value="">All Statuses</option>
                        <option value="Pending">Pending</option>
                        <option value="Confirmed">Confirmed</option>
                        <option value="Cancelled">Cancelled</option>
                    </select>
                    <button class="show-all-btn" onclick="resetSearch('Booking')">Show All</button>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>BookingID</th>
                            <th>UserName</th>
                            <th>RoomNumber</th>
                            <th>CheckIn</th>
                            <th>CheckOut</th>
                            <th>BookingStatus</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>

            <!-- Room Table -->
            <div id="Room" class="entity-table">
                <h3>Manage Rooms</h3>
                <div class="search-container">
                    <input type="text" class="search-bar" placeholder="Search Rooms..." onkeyup="searchTable(this, 'Room')">
                     <select class="filter-dropdown" onchange="filterStatus(this, 'Room')">
                        <option value="">All Statuses</option>
                        <option value="Available">Available</option>
                        <option value="Occupied">Occupied</option>
                    </select>
                    <button class="show-all-btn" onclick="resetSearch('Room')">Show All</button>
                    
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>RoomID</th>
                            <th>RoomNumber</th>
                            <th>RoomTypeID</th>
                            <th>RoomStatus</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>

            <!-- Room Type Table -->
            <div id="RoomType" class="entity-table">
                <h3>Manage Room Types</h3>
                <div class="search-container">
                    <input type="text" class="search-bar" placeholder="Search Room Types..." onkeyup="searchTable(this, 'RoomType')">
                    <button class="show-all-btn" onclick="resetSearch('RoomType')">Show All</button>
                    <button class="add-btn">Add</button>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>RoomTypeID</th>
                            <th>Price per Night</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
<div class="popup-form" id="popupForm">
        <h3>Add New Room Type</h3>
        <label>Room Type Name:</label>
        <input type="text" id="roomTypeName" placeholder="Enter room type name" name="txtRoomTypeName">
        
        <label>Price Per Night:</label>
        <input type="number" id="pricePerNight" placeholder="Enter price per night" name="txtPrice" >
        
        <label>Description:</label>
        <textarea id="description" placeholder="Enter description" name="txtDescription" ></textarea>
        
        <div class="popup-buttons">
            <button class="save-btn" onclick="saveRoomType()">Save</button>
            <button class="cancel-btn" onclick="closePopup()">Cancel</button>
        </div>
</div>
            <!-- Invoice Table -->
            <div id="Invoice" class="entity-table">
                <h3>Manage Invoices</h3>
                <div class="search-container">
                    <input type="text" class="search-bar" placeholder="Search Invoices..." onkeyup="searchTable(this, 'Invoice')">
                    <select class="filter-dropdown" onchange="filterStatus(this, 'Invoice')">
                        <option value="">All Statuses</option>
                        <option value="Paid">Paid</option>
                        <option value="Unpaid">Unpaid</option>
                    </select>
                    <button class="show-all-btn" onclick="resetSearch('Invoice')">Show All</button>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>InvoiceID</th>
                            <th>BookingID</th>
                            <th>TotalPrice</th>
                            <th>PaymentStatus</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>
    
    <script>
         document.addEventListener("DOMContentLoaded", function () {
    showTable("User"); // Hiển thị bảng Users khi tải trang

    // Thêm sự kiện cho nút Add trong RoomType
    document.querySelector(".add-btn").addEventListener("click", function () {
        document.getElementById("popupForm").style.display = "block";
    });
});

// Hàm đóng popup
function closePopup() {
    document.getElementById("popupForm").style.display = "none";
}

// Hàm lưu dữ liệu (có thể cập nhật sau này)
function saveRoomType() {
    alert("Room Type Saved!"); // Thông báo tạm thời
    closePopup(); // Đóng popup sau khi lưu
}
        function showTable(entity) {
            document.querySelectorAll(".entity-table").forEach(table => table.style.display = "none");
            document.getElementById(entity).style.display = "block";
        }
        function addEntry(entity) {
            let tableBody = document.getElementById(entity.toLowerCase() + "TableBody");
            let newRow = document.createElement("tr");
            newRow.innerHTML = `
                <td>1</td>
                <td>Sample ${entity}</td>
                <td>sample@example.com</td>
                <td>
                    <button onclick='deleteEntry(this)'>Delete</button>
                </td>`;
            tableBody.appendChild(newRow);
        }
        function deleteEntry(button) {
            button.parentElement.parentElement.remove();
        }
          function toggleSidebar() {
            document.getElementById("sidebar").classList.toggle("active");
        }
        
        function showTable(entity) {
            document.querySelectorAll(".entity-table").forEach(table => table.style.display = "none");
            document.getElementById(entity).style.display = "block";
        }
        
        function searchTable(input, tableId) {
            let filter = input.value.toLowerCase();
            let table = document.getElementById(tableId).getElementsByTagName("table")[0];
            let tr = table.getElementsByTagName("tr");
            
            for (let i = 1; i < tr.length; i++) {
                let td = tr[i].getElementsByTagName("td");
                let found = false;
                for (let j = 0; j < td.length; j++) {
                    if (td[j] && td[j].innerText.toLowerCase().indexOf(filter) > -1) {
                        found = true;
                        break;
                    }
                }
                tr[i].style.display = found ? "" : "none";
            }
        }
    </script>
</body>
</html>