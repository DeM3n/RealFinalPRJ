/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class BookingDTO {
    private int BookingID;
    private int UserID;
    private int RoomID;
    private Date checkIn;
    private Date checkOut;
    private double TotalPrice;
    private String BookingStatus;

    public BookingDTO() {
    }

    public BookingDTO(int BookingID, int UserID, int RoomID, Date checkIn, Date checkOut, double TotalPrice, String BookingStatus) {
        this.BookingID = BookingID;
        this.UserID = UserID;
        this.RoomID = RoomID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.TotalPrice = TotalPrice;
        this.BookingStatus = BookingStatus;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int BookingID) {
        this.BookingID = BookingID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public String getBookingStatus() {
        return BookingStatus;
    }

    public void setBookingStatus(String BookingStatus) {
        this.BookingStatus = BookingStatus;
    }
    
}
