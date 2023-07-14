package Users.Customer;

import java.sql.SQLException;

import DatabaseSystem.AdminDb;
import Users.Administration.Bus;

public class Ticket {
    private String ticketID;
    private String busID;
    private String customerMobileNumber;
    private String journeyDate;
    public static AdminDb adminDb = new AdminDb();
    
    
    public Ticket(String ticketID, String busID, String customerMobileNumber, String journeyDate) {
        this.ticketID = ticketID;
        this.busID = busID;
        this.customerMobileNumber = customerMobileNumber;
        this.journeyDate = journeyDate;
    }
    public String getTicketID() {
        return ticketID;
    }
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    public String getBusID() {
        return busID;
    }
    public void setBusID(String busID) {
        this.busID = busID;
    }
    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }
    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }
    public String getJourneyDate() {
        return journeyDate;
    }
    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public void printTicketDetails() throws SQLException{
        Bus bus = adminDb.getBusRecord(getBusID());
        if(bus==null)return;
        System.out.println("********************************************************");
        System.out.println("Ticket ID : "+getTicketID());
        System.out.println("Mobile Number : +"+getCustomerMobileNumber());
        System.out.println("Journey : "+bus.getBoardingPoint()+" --> "+bus.getDroppingPoint());
        System.out.println("Journey Time : "+bus.getDepartureTime()+" --> "+bus.getArrivalTime());
        System.out.println("Jouney Date : "+getJourneyDate() );
        System.out.println("Price : Rs "+bus.getPrice());
        System.out.println("Happy Journey! Project Winners");
        System.out.println("********************************************************");

    }
    
}
