/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.RoomTypeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author HP
 */
public class RoomTypeDAO implements IDAO<RoomTypeDTO,Integer> {
private ArrayList<String> RoomTypeList;
 private List<RoomTypeDTO> RoomList;

 
 
    @Override
    public boolean create(RoomTypeDTO entity) {
        Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success= false;
         try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO RoomType(RoomTypeName, PricePerNight, Description)\n"
                        + "VALUES (?,?,?);";
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

    @Override
    public List<RoomTypeDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoomTypeDTO readById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(RoomTypeDTO entity) {
   return false;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RoomTypeDTO> search(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
