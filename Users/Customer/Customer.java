package Users.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import java.io.FileReader;  
import java.io.IOException;
import java.sql.SQLException;

import DatabaseSystem.CustomerDb;
import DatabaseSystem.UserDb;
import Users.User;

public class Customer extends User {
  
    private String userName;
    private String paymentType;
    private ArrayList<Ticket> previousBookings;
    private static CustomerDb customerDb = new CustomerDb();
   

    public Customer(String mobileNumber, String password, String age, String gender, String type, String loginStatus) {
    super(mobileNumber, password, age, gender, type, loginStatus);
    
    }

    public Customer(String mobileNumber, String password, String age, String gender, String type, String loginStatus,
            String userName, String paymentType) {
        super(mobileNumber, password, age, gender, type, loginStatus);
        this.userName = userName;
        this.paymentType = paymentType;
    }
    public Customer(){
        super(null,null,null,null,null,null);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public ArrayList<Ticket> getPreviousBookings() {
        return previousBookings;
    }

    public void setPreviousBookings(ArrayList<Ticket> previousBookings) {
        this.previousBookings = previousBookings;
    }

    @Override
    public boolean userLogin(String mobileNumber, String password) throws SQLException {
        String userPassword = customerDb.getUserPassword(mobileNumber);
        if(userPassword.equals(password)){
         this.setLoginStatus("true");
         customerDb.updateUserLoginStatus(getMobileNumber(), getLoginStatus());
         return true;
     }
        else return false;
         
     }
    
    @Override
    public boolean userLogout(String mobileNumber) throws SQLException {
       this.setLoginStatus("false");
        return customerDb.updateUserLoginStatus(mobileNumber, "false");
    }

    public boolean bookTicket(String busID,String mobileNumber,String journeyDate) throws SQLException{
        Ticket ticket = new Ticket(busID+mobileNumber, busID, mobileNumber, journeyDate);
        if(customerDb.addTicket(ticket)){
            System.out.println("Ticket Booked!");
            System.out.println("Ticket Details : ");
            ticket.printTicketDetails();
            return true;
        }
        else {
            System.out.println("Booking Failed!");
            return false;
        }
    }

    @Override
    public boolean userRegister(String csvPath) throws SQLException {
        CSVReader reader = null;  
        try  
        {  
        reader = new CSVReader(new FileReader(csvPath));    
        String [] nL;  
        nL=reader.readNext();
        if(nL==null) return false;
        this.setMobileNumber(nL[0]);
        this.setPassword(nL[1]);
        this.setAge(nL[2]);
        this.setGender(nL[3]);
        this.setType(nL[4]);
        this.setLoginStatus("true");
        this.setUserName(nL[5]);    
        this.setPaymentType(nL[6]);
        return(customerDb.addUserRecord(this));
        }  
        catch (Exception e)   
        {  
        e.printStackTrace(); 
        return false ;
        }  
       
    }

    @Override
    public String toString() {
        return "Customer [userName=" + userName + ", paymentType=" + paymentType + ", previousBookings="
                + previousBookings + "]";
    }


    
    
}
