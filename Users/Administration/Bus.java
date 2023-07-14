package Users.Administration;

public class Bus {
    
    private String busID;
    private String boardingPoint;
    private String droppingPoint;
    private String departureTime;
    private String arrivalTime;
    private String price;
    
    public Bus(String busID, String boardingPoint, String droppingPoint, String departureTime, String arrivalTime,
            String price) {
        this.busID = busID;
        this.boardingPoint = boardingPoint;
        this.droppingPoint = droppingPoint;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }
    public String getBusID() {
        return busID;
    }
    public void setBusID(String busID) {
        this.busID = busID;
    }
    public String getBoardingPoint() {
        return boardingPoint;
    }
    public void setBoardingPoint(String boardingPoint) {
        this.boardingPoint = boardingPoint;
    }
    public String getDroppingPoint() {
        return droppingPoint;
    }
    public void setDroppingPoint(String droppingPoint) {
        this.droppingPoint = droppingPoint;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
    public void printBusDetails(){
        System.out.println("BusID : "+getBusID());
        System.out.println("BoardingPoint --> DroppingPoint : "+getBoardingPoint() +" --> "+getDroppingPoint());
        System.out.println("DepartureTime --> ArrivalTime   : "+getDepartureTime() + " --> "+getArrivalTime());
        System.out.println("Ticket Price : Rs "+getPrice());
        System.out.println("**********************************************************************************************");
    }
   
    
    
}
