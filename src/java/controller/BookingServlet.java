/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookingDAO;
import dao.InvoiceDAO;
import dao.RoomDAO;
import dao.RoomTypeDAO;
import dto.BookingDTO;
import dto.InvoiceDTO;
import dto.RoomDTO;
import dto.RoomTypeDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AuthUtils;

/**
 *
 * @author HP
 */
@WebServlet(name = "BookingServlet", urlPatterns = {"/BookingServlet"})
public class BookingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String BookingSuccess="Home.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (!AuthUtils.isLoggedIn(request.getSession())) {
   
    request.getRequestDispatcher("login.jsp").forward(request, response);
    return;
}
            String CheckInStr=request.getParameter("txtCheckIn");
            String CheckOutStr=request.getParameter("txtCheckOut");
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
               LocalDate CheckInDate = LocalDate.parse(CheckInStr, formatter);
                LocalDate CheckOutDate = LocalDate.parse(CheckOutStr, formatter);
                 LocalDate today = LocalDate.now();
                 if(CheckInDate.isBefore(today)){
                      request.setAttribute("errorMessage", "Check-in date cannot be in the past.");
                       request.setAttribute("showPopup", true);
                request.getRequestDispatcher("Home.jsp").forward(request, response);
                return;
                 }
                 if(CheckOutDate.isBefore(CheckInDate) || CheckOutDate.isEqual(CheckInDate)){
                    request.setAttribute("errorMessage", "Check-out date must be after the check-in date.");
                     request.setAttribute("showPopup", true);
                    request.getRequestDispatcher("Home.jsp").forward(request, response);
                 }
               int RoomTypeID= Integer.parseInt(request.getParameter("txtRoomType"));
               RoomDAO roomdao = new RoomDAO();
               RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
               // lay roomID
               RoomDTO room = roomdao.selectRoomByRoomTypeID(RoomTypeID);
               // lay ngay
               Date CheckIn = Date.valueOf(CheckInDate); 
               Date CheckOut = Date.valueOf(CheckOutDate); 
               //lay user ID
               UserDTO user = (UserDTO)request.getSession().getAttribute("user");
               int UserID = user.getUserID();
               // tao booking 
               BookingDTO booking = new BookingDTO(UserID,room.getRoomID(),CheckIn,CheckOut,"Pending");
               BookingDAO bookingdao = new BookingDAO();
              boolean bookingCreated = bookingdao.createBooking(booking);
               roomdao.UpdateRoomStatusUS(room);
               //tinh total price 
               RoomTypeDTO roomType=roomTypeDAO.SearchTypeByID(RoomTypeID);
               long daysStayed;
            daysStayed = ChronoUnit.DAYS.between(CheckIn.toLocalDate(), CheckOut.toLocalDate());
            Double totalPrice = daysStayed * roomType.getPricePerNight();
            System.out.println(daysStayed);
            System.out.println("hhhhh");
                   System.out.println(totalPrice);
               // tao invoice step 
               if(bookingCreated){
                   int BookingID = bookingdao.getLatestBookingID(UserID);
                   System.out.println("BookingID retrieved: " + BookingID);
                   System.out.println(totalPrice);
                   if(BookingID > 0){
                       InvoiceDAO invoiceDao = new InvoiceDAO();
                       InvoiceDTO invoice = new InvoiceDTO(BookingID,"Unpaid",totalPrice);
        invoiceDao.createInvoice(invoice);
                   }
               }
            request.getRequestDispatcher("Home.jsp").forward(request, response);       
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
