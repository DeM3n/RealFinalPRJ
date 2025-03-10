/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RoomTypeDAO;
import dto.RoomTypeDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AuthUtils;

/**
 *
 * @author HP
 */
@WebServlet(name = "AddRoomTypeServlet", urlPatterns = {"/AddRoomTypeServlet"})
public class AddRoomTypeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String Admin_Page = "AdminPage.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            /* TODO output your page here. You may use following sample code. */
          if (AuthUtils.isLoggedIn(session) && AuthUtils.isAdmin(session)) {
      String roomTypeName = request.getParameter("txtRoomTypeName");
       String priceStr = request.getParameter("txtPrice");
      String description = request.getParameter("txtDescription");
      if (roomTypeName == null || roomTypeName.trim().isEmpty() || 
        priceStr == null || priceStr.trim().isEmpty() || 
        description == null || description.trim().isEmpty()) {
        
        request.setAttribute("error", "All fields are required.");
        request.getRequestDispatcher("Admin_Page").forward(request, response);
        return;
    }
      double price;
    try {
        price = Double.parseDouble(priceStr);
        if (price <= 0) {
            request.setAttribute("error", "Price must be greater than 0.");
            request.getRequestDispatcher("Admin_Page").forward(request, response);
            return;
        }
    } catch (NumberFormatException e) {
        request.setAttribute("error", "Invalid price format.");
        request.getRequestDispatcher("Admin_Page").forward(request, response);
        return;
    }
      RoomTypeDTO roomType = new RoomTypeDTO(roomTypeName,price,description);
      RoomTypeDAO roomTypedao = new RoomTypeDAO();
      roomTypedao.createRoomType(roomType);
      
      
} else {
   
    response.sendRedirect("login.jsp"); 
}
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
