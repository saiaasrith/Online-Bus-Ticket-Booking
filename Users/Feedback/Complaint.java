package Users.Feedback;



public class Complaint {
    private String complaintStatement;
    private String userMobileNumber;
    private String complaintID;
    public Complaint(String complaintStatement, String userMobileNumber, String complaintID) {
        this.complaintStatement = complaintStatement;
        this.userMobileNumber = userMobileNumber;
        this.complaintID = complaintID;
    }
    public String getComplaintStatement() {
        return complaintStatement;
    }
    public void setComplaintStatement(String complaintStatement) {
        this.complaintStatement = complaintStatement;
    }
   
    public String getComplaintID() {
        return complaintID;
    }
    public void setComplaintID(String complaintID) {
        this.complaintID = complaintID;
    }
    public String getUserMobileNumber() {
        return userMobileNumber;
    }
    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }
    
}
