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
public class InvoiceDTO {
    private int InvoiceID;
    private int BookingID;
    private double TotalAmount;
    private String InvoiceStatus;

    public InvoiceDTO() {
    }

    public InvoiceDTO(int InvoiceID, int BookingID, double TotalAmount, String InvoiceStatus) {
        this.InvoiceID = InvoiceID;
        this.BookingID = BookingID;
        this.TotalAmount = TotalAmount;
        this.InvoiceStatus = InvoiceStatus;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int BookingID) {
        this.BookingID = BookingID;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(double TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public String getInvoiceStatus() {
        return InvoiceStatus;
    }

    public void setInvoiceStatus(String InvoiceStatus) {
        this.InvoiceStatus = InvoiceStatus;
    }
    
}
