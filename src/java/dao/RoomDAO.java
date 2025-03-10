/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.RoomDTO;
import dto.RoomTypeDTO;
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
public class RoomDAO {

    public List<RoomDTO> readAll() {
        List<RoomDTO> RoomList = new ArrayList();
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "Select * \n"
                        + "  From Room ";
                stm = cn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {

                    RoomDTO room = new RoomDTO(
                            rs.getInt("RoomID"),
                            rs.getInt("RoomTypeID"),
                            rs.getString("RoomNumber"),
                            rs.getString("RoomStatus")
                    );
                    RoomList.add(room);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) { // Close ResultSet
                    rs.close();
                }
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
        return RoomList;
    }

    public List<RoomDTO> SearchRoomByStatus(String Status) {
        List<RoomDTO> RoomList = new ArrayList();
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "Select * from Room WHERE RoomStatus like ?  ";
                stm = cn.prepareStatement(sql);
                stm.setString(1, Status);
                rs=stm.executeQuery();
                while (rs.next()) {
                    RoomDTO room = new RoomDTO(
                            rs.getInt("RoomID"),
                            rs.getInt("RoomTypeID"),
                            rs.getString("RoomNumber"),
                            rs.getString("RoomStatus")
                    );
                    RoomList.add(room);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) { // Close ResultSet
                    rs.close();
                }
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
        return RoomList;
    }

    /// van con khuc mat chua finished
    public List<RoomDTO> SearchRoomByID(int id) {
        List<RoomDTO> RoomList = new ArrayList();
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "Select * from Room WHERE RoomID = ?  ";
                stm = cn.prepareStatement(sql);
                stm.setInt(1, id);
                rs=stm.executeQuery();
                while (rs.next()) {
                    RoomDTO room = new RoomDTO(
                            rs.getInt("RoomID"),
                            rs.getInt("RoomTypeID"),
                            rs.getString("RoomNumber"),
                            rs.getString("RoomStatus")
                    );
                    RoomList.add(room);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) { // Close ResultSet
                    rs.close();
                }
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
        return RoomList;
    }

    public boolean updateStatusAD(RoomDTO entity) {
        Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success = false;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Room SET RoomStatus = CASE "
                        + "WHEN RoomStatus = 'Available' THEN 'Maintenance' "
                        + "WHEN RoomStatus = 'Maintenance' THEN 'Available' "
                        + "ELSE RoomStatus END "
                        + "WHERE RoomID = ?";
                stm = cn.prepareStatement(sql);
                stm.setInt(1, entity.getRoomID());

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

    public boolean UpdateRoomStatusUS(RoomDTO entity) {
        Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success = false;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Room SET RoomStatus = CASE "
                        + "WHEN RoomStatus = 'Available' THEN 'Booked' "
                        + "WHEN RoomStatus = 'Booked' THEN 'Available' "
                        + "ELSE RoomStatus END "
                        + "WHERE RoomID = ?";
                stm = cn.prepareStatement(sql);
                stm.setInt(1, entity.getRoomID());

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
public RoomDTO selectRoomByRoomTypeID(int id) { 
    RoomDTO room = null; // Store a single room
    Connection cn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    
    try {
        cn = DBUtils.getConnection();
        if (cn != null) {
            // Prioritize available rooms, smallest RoomID first
            String sql = "SELECT * FROM Room WHERE RoomTypeID = ? AND RoomStatus = 'Available' ORDER BY RoomID ASC";
            stm = cn.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            
            if (rs.next()) { // Get the first available room
                room = new RoomDTO(
                    rs.getInt("RoomID"),
                    rs.getInt("RoomTypeID"),
                    rs.getString("RoomNumber"),
                    rs.getString("RoomStatus")
                );
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
    return room; // Return the first available room or null
}

}
