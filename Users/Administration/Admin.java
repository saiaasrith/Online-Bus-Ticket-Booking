package Users.Administration;

import DatabaseSystem.AdminDb;
import Users.User;
import java.io.FileReader;  
import java.io.IOException;
import java.sql.SQLException;

import com.opencsv.CSVReader;  

public class Admin extends User{
    
    private static AdminDb adminDb = new AdminDb();
    
    public Admin(String mobileNumber, String password, String age, String gender, String type, String loginStatus) {
        super(mobileNumber, password, age, gender, type, loginStatus);
    }

    public Admin() {
        super(null,null,null,null,null,null);
    }

    public static boolean addBus(String pathCSV){
        CSVReader reader = null;  
        try  
        {  
        reader = new CSVReader(new FileReader(pathCSV));    
        String [] nL;  
        reader.readNext();
        //read one line at a time  
            while ((nL = reader.readNext()) != null)  
            {  
               Bus bus = new Bus(nL[0],nL[1],nL[2],nL[3],nL[4],nL[5]);
               if(adminDb.getBusRecord(bus.getBusID())==null){
                adminDb.insertBusRecord(bus);
                System.out.println("Added bus with Bus ID = "+bus.getBusID());
               }else{
                adminDb.updateBusRecord(bus);
                System.out.println("updated bus with ID = "+bus.getBusID());
               }
            }
            return true; 
        }  
        catch (Exception e)   
        {  
        e.printStackTrace(); 
        return false ;
        }  

    }

    @Override
    public boolean userLogin(String mobileNumber,String password) throws SQLException {
        String userPassword = adminDb.getUserPassword(mobileNumber);
        if(userPassword.equals(password)){
         this.setLoginStatus("true");
         adminDb.updateUserLoginStatus(getMobileNumber(), getLoginStatus());
         return true;
     }
        else return false;
    }

    @Override
    public boolean userLogout(String mobileNumber) throws SQLException {
        this.setLoginStatus("false");
        return adminDb.updateUserLoginStatus(mobileNumber, "false");
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
        
        return(adminDb.addUserRecord(this));
        }  
        catch (Exception e)   
        {  
        e.printStackTrace(); 
        return false ;
        }  
    }
    
}
