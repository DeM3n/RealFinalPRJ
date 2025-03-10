/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

/**
 *
 * @author no-solace
 */
public class RoomDTO {
private int RoomID;
private int RoomTypeID;
private String RoomNumber;
private String RoomStatus;
private RoomTypeDTO RoomType;

    public RoomDTO() {
    }
    
    public RoomDTO(int RoomID, int RoomTypeID, String RoomNumber, String RoomStatus, RoomTypeDTO RoomType) {
        this.RoomID = RoomID;
        this.RoomTypeID = RoomTypeID;
        this.RoomNumber = RoomNumber;
        this.RoomStatus = RoomStatus;
        this.RoomType = RoomType;
    }

    public RoomDTO(int RoomID, int RoomTypeID, String RoomNumber, String RoomStatus) {
        this.RoomID = RoomID;
        this.RoomTypeID = RoomTypeID;
        this.RoomNumber = RoomNumber;
        this.RoomStatus = RoomStatus;
        this.RoomType = null; 
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public int getRoomTypeID() {
        return RoomTypeID;
    }

    public void setRoomTypeID(int RoomTypeID) {
        this.RoomTypeID = RoomTypeID;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public String getRoomStatus() {
        return RoomStatus;
    }

    public void setRoomStatus(String RoomStatus) {
        this.RoomStatus = RoomStatus;
    }

    public RoomTypeDTO getRoomType() {
        return RoomType;
    }

    public void setRoomType(RoomTypeDTO RoomType) {
        this.RoomType = RoomType;
    }

}
