/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author HP
 */
public class RoomTypeDTO {
    private int RoomTypeID;
    private String RoomTypeName;
    private double PricePerNight;
    private String Description;

    public RoomTypeDTO() {
    }

    public RoomTypeDTO(int RoomTypeID, String RoomTypeName, double PricePerNight, String Description) {
        this.RoomTypeID = RoomTypeID;
        this.RoomTypeName = RoomTypeName;
        this.PricePerNight = PricePerNight;
        this.Description = Description;
    }

    public int getRoomTypeID() {
        return RoomTypeID;
    }

    public void setRoomTypeID(int RoomTypeID) {
        this.RoomTypeID = RoomTypeID;
    }

    public String getRoomTypeName() {
        return RoomTypeName;
    }

    public void setRoomTypeName(String RoomTypeName) {
        this.RoomTypeName = RoomTypeName;
    }

    public double getPricePerNight() {
        return PricePerNight;
    }

    public void setPricePerNight(double PricePerNight) {
        this.PricePerNight = PricePerNight;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
