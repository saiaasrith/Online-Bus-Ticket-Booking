package Users;

import java.sql.SQLException;

public abstract class User {
    private String mobileNumber;
    private String password;
    private String age;
    private String gender;
    private String type;
    private String loginStatus;
    
   
    
    @Override
    public String toString() {
        return "User [mobileNumber=" + mobileNumber + ", password=" + password + ", age=" + age + ", gender=" + gender
                + ", type=" + type + ", loginStatus=" + loginStatus + "]";
    }
    public User(String mobileNumber, String password, String age, String gender, String type, String loginStatus) {
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.type = type;
        this.loginStatus = loginStatus;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getLoginStatus() {
        return loginStatus;
    }
    
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
   
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
   
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public abstract boolean userLogin(String mobileNumber,String password) throws SQLException;
    public abstract boolean userLogout(String mobileNumber) throws SQLException;
    public abstract boolean userRegister(String csvPath) throws SQLException;
    

}
