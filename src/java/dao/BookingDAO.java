/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.BookingDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author HP
 */
public class BookingDAO {

    public boolean createBooking(BookingDTO entity) {
        Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success = false;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Booking(UserID, RoomID, CheckInDate,CheckOutDate,BookingStatus)\n"
                        + "VALUES (?,?,?,?,?);";
                stm = cn.prepareStatement(sql);
                stm.setInt(1, entity.getUserID());
                stm.setInt(2, entity.getRoomID());
                stm.setDate(3, entity.getCheckIn());
                stm.setDate(4, entity.getCheckOut());
                stm.setString(5, entity.getBookingStatus());

                row = stm.executeUpdate();

                if (row > 0) {
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
//close to reduce slow and crash
                if (stm != null) {
                    stm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public List<BookingDTO> SearchByBookingStatus(String status) {
        List<BookingDTO> BookingList = new ArrayList();
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "Select * from Booking Where BookingStatus LIKE ?";

                stm = cn.prepareStatement(sql);
                stm.setString(1, status);
                rs = stm.executeQuery();
                while (rs.next()) {
                    BookingDTO booking = new BookingDTO(
                            rs.getInt("BookingID"),
                            rs.getInt("UserID"),
                            rs.getInt("RoomID"),
                            rs.getDate("CheckInDate"),
                            rs.getDate("CheckOutDate"),
                          
                            rs.getString("BookingStatus")
                    );
                    BookingList.add(booking);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (cn != null) {
                    cn.close();
                }
                if (rs != null) { // Close ResultSet
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return BookingList;
    }

    public List<BookingDTO> readAll() {
        return null;
    }

   public boolean updateBookingStatus(int bookingID, String status) {
    Connection cn = null;
    PreparedStatement stm = null;
    boolean success = false;

    try {
        cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE Booking SET BookingStatus = ? WHERE BookingID = ?";
            stm = cn.prepareStatement(sql);
            stm.setString(1, status);
            stm.setInt(2, bookingID);

            int row = stm.executeUpdate();
            success = row > 0; // Returns true if at least one row is updated
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (stm != null) stm.close();
            if (cn != null) cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return success;
}
   public boolean confirmBooking(int bookingID) {
    return updateBookingStatus(bookingID, "Confirmed");
}

public boolean cancelBooking(int bookingID) {
    return updateBookingStatus(bookingID, "Cancelled");
}

    public boolean deleteBooking(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public int getLatestBookingID(int userID) {
    Connection cn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    int bookingID = -1; // Default value

    try {
        cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT TOP 1 BookingID FROM Booking WHERE UserID = ? ORDER BY BookingID DESC";
            stm = cn.prepareStatement(sql);
            stm.setInt(1, userID);
            rs = stm.executeQuery();

            if (rs.next()) {
                bookingID = rs.getInt("BookingID"); // Get latest BookingID
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (cn != null) cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return bookingID; // Return latest BookingID
}
}
