package DatabaseSystem;

import java.sql.*;
import java.util.ArrayList;

import Users.User;
import Users.Administration.Admin;
import Users.Administration.Bus;
import Users.Customer.Customer;

public class UserDb {
    private  Connection connection;
    private  Database database;
    protected  Statement statement;
    protected   ResultSet rs;

    public UserDb() {
        database = new Database();
        
       try {
       
        connection = DriverManager.getConnection(database.getDbURL(),database.getDbUserName(),database.getDbPassword());
         statement = connection.createStatement();
        } catch (SQLException e) {
       
            e.printStackTrace();
        }
    }

    public   boolean addUserRecord(User user) throws SQLException{
        String Query = "insert into user values('"+user.getMobileNumber()+"','"+user.getPassword()+"','"+user.getAge()+"','"+user.getGender()+"','"+user.getType()+"','"+user.getLoginStatus()+"')";
        return !statement.execute(Query);
    }
     
    public  boolean deleteUserRecord(User user) throws SQLException{
        String Query = "delete from user where mobileNumber="+user.getMobileNumber();
        return !statement.execute(Query);
    }

    public String getUserPassword(String mobileNumber) throws SQLException{
        String Query = "select password from user where mobileNumber = "+mobileNumber;
        rs = statement.executeQuery(Query);
        if(rs.next())return rs.getString("password");
        else return null;
    }

    public String getUserLoginStatus(String mobileNumber) throws SQLException{
        String Query = "select loginStatus from user where mobileNumber  = '"+mobileNumber+"'";
        rs = statement.executeQuery(Query);
        if(rs.next()){
            String loginStatus = rs.getString("loginStatus");
            return loginStatus;
        }
        return null;
    }

    public  boolean updateUserLoginStatus(String mobileNumber,String status) throws SQLException{
        String Query = "update user set loginstatus ='"+status+"' where mobileNumber = '"+mobileNumber+"'";
        return !statement.execute(Query);
    }

    public User getUser(String mobileNumber) throws SQLException{
        String Query = "select * from user where mobileNumber = '"+mobileNumber+"'";
        rs = statement.executeQuery(Query);
        User user = null;
        if(rs.next()){
            String type = rs.getString("type");
            if(type.toLowerCase().equals("customer")){
                
                user = new Customer(rs.getString("mobileNumber"),rs.getString("password"),rs.getString("age"),rs.getString("gender"),rs.getString("type"),rs.getString("loginStatus"));
            }
            else if(type.toLowerCase().equals("admin")){
                user = new Admin(rs.getString("mobileNumber"),rs.getString("password"),rs.getString("age"),rs.getString("gender"),rs.getString("type"),rs.getString("loginStatus"));
            
            }
        }
        return user;
    }

    public ArrayList<Bus> getAllBus() throws SQLException{
        String Query = "select * from bus";
        rs = statement.executeQuery(Query);
        ArrayList<Bus> bus = new ArrayList<>();
        while(rs.next()){
            bus.add(new Bus(rs.getString("busID"),rs.getString("boardingPoint"),rs.getString("droppingPoint"),rs.getString("departureTime"),rs.getString("arrivalTime"),rs.getString("price")));
        }
        return bus;
    }
}
