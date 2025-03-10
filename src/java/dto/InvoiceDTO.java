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
    private Double TotalPrice;
    private String InvoiceStatus;

    public InvoiceDTO() {
    }

    public InvoiceDTO(int BookingID, String InvoiceStatus,Double TotalPrice) {
        this.BookingID = BookingID;        
        this.InvoiceStatus = InvoiceStatus;
         this.TotalPrice = TotalPrice;
    }

    public InvoiceDTO(int InvoiceID, int BookingID, Double TotalPrice, String InvoiceStatus) {
        this.InvoiceID = InvoiceID;
        this.BookingID = BookingID;
        this.TotalPrice = TotalPrice;
        this.InvoiceStatus = InvoiceStatus;
    }

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Double TotalPrice) {
        this.TotalPrice = TotalPrice;
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

  

    public String getInvoiceStatus() {
        return InvoiceStatus;
    }

    public void setInvoiceStatus(String InvoiceStatus) {
        this.InvoiceStatus = InvoiceStatus;
    }
    
}
