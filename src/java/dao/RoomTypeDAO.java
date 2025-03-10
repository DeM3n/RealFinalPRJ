/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class RoomTypeDAO  {
private ArrayList<String> RoomTypeList;
 private List<RoomTypeDTO> RoomList;

    public List<RoomTypeDTO> getRoomType() {
        return RoomList;
    }
     public void displayRoomTypeAndPrice(){
           Connection cn = null;
    PreparedStatement stm = null;
    ResultSet table = null;

    try {
        cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT * FROM RoomType"; 
            stm = cn.prepareStatement(sql);
            table = stm.executeQuery();

            // Ensure RoomTypeList is initialized
            if (RoomList == null) {
                RoomList = new ArrayList<>();
            } else {
                RoomTypeList.clear(); // Clear previous data
            }

            while (table.next()) {
               int roomTypeID = table.getInt("RoomTypeID");
                String roomTypeName = table.getString("RoomTypeName"); 
                double pricePerNight = table.getDouble("PricePerNight"); 
                String description = table.getString("Description"); 
                // Create a RoomTypeDTO object and add it to the list
                RoomList.add(new RoomTypeDTO(roomTypeID, roomTypeName, pricePerNight, description));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (table != null) table.close();
            if (stm != null) stm.close();
            if (cn != null) cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       }
     }
 
   
    public boolean createRoomType(RoomTypeDTO entity) {
        Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success= false;
         try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO RoomType(RoomTypeName, PricePerNight, Description)\n"
                        + "VALUES (?,?,?)";
                stm = cn.prepareStatement(sql);
               
                stm.setString(1,entity.getRoomTypeName());
                stm.setDouble(2,entity.getPricePerNight());
                stm.setString(3,entity.getDescription());

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

 

 
    public boolean updateRoomType(RoomTypeDTO entity) {
    Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success= false;
         try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE RoomType SET RoomTypeName = ?, PricePerNight = ?, Description = ? WHERE RoomTypeID = ?";
            stm = cn.prepareStatement(sql);
            stm.setString(1, entity.getRoomTypeName());
            stm.setDouble(2, entity.getPricePerNight());
            stm.setString(3, entity.getDescription());
            stm.setInt(4, entity.getRoomTypeID());

                row = stm.executeUpdate();

                if (row > 0) {
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) stm.close();
                if (cn != null)  cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    
    public boolean delete(Integer id) {
        Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success= false;
         try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "Delete FROM RoomType WHERE RoomTypeID = ?";
            stm = cn.prepareStatement(sql);
            stm.setInt(1,id);
                row = stm.executeUpdate();

                if (row > 0) {
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) stm.close();
                if (cn != null)  cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public RoomTypeDTO SearchTypeByID(Integer id) {
         
         Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if(cn!=null){
                String sql="Select * from RoomType Where RoomTypeID = ?";
               
                stm = cn.prepareStatement(sql);
                 stm.setInt(1, id);
                rs=stm.executeQuery();
                if(rs.next()){
                   RoomTypeDTO roomType = new RoomTypeDTO(
                   rs.getInt("RoomTypeID"),
                   rs.getString("RoomTypeName"), 
                   rs.getDouble("PricePerNight"),   
                   rs.getString("Description")           
                   );
                  return roomType;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(stm !=null){
                    stm.close();
                }
               if(cn!=null){
                   cn.close();
               } 
                if (rs != null) { // Close ResultSet
                rs.close();
            }
            }catch (Exception e){
            e.printStackTrace();
        }
            
        }
         return null;
    }
}
