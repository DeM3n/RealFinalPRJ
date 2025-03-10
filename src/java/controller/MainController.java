/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RoomDAO;
import dao.RoomTypeDAO;
import dao.UserDAO;
import dto.RoomDTO;
import dto.RoomTypeDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private final String RegisterServlet="RegisterServlet";
    private final String LoginServlet = "LoginServlet";
    private final String LogoutServlet = "LogoutServlet";
    private static final String LOGIN_PAGE = "login.jsp";
    private final String BookingServlet="BookingServlet";
    private final String UpdateUserServlet ="UpdateUserServlet";
    private final String AddRoomTypeServelet="AddRoomTypeServelet";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
         
        try {
            String action = request.getParameter("action");
            RoomTypeDAO roomdao = new RoomTypeDAO();
    roomdao.displayRoomTypeAndPrice();
    List<RoomTypeDTO> roomTypes = roomdao.getRoomType();
    request.setAttribute("roomTypes", roomTypes);
            if (action == null) {
                
                url = LOGIN_PAGE;
            } else if (action.equals("login")) {
              
                url = LoginServlet;
            } else if (action.equals("logout")) {
                url = LogoutServlet;
            } else if (action.equals("test")) {
                System.out.println("hihi");
               // int id = Integer.parseInt(request.getParameter("txtID"));
                String Status=request.getParameter("txtStatus");
                RoomDAO room = new RoomDAO();
                List<RoomDTO> rooms = room.SearchRoomByStatus(Status);

                request.setAttribute("rooms", rooms);
                url="test.jsp";
            } else if (action.equals("register")){
                url=RegisterServlet;
            } else if (action.equals("booknow")){
                url=BookingServlet;
            } else if (action.equals("updateProfile")){
                url=UpdateUserServlet;
            }
        } catch (Exception e) {
            log("Error in MainController: " + e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
