package DatabaseSystem;

import java.sql.SQLException;

import Users.Administration.Bus;

public class AdminDb extends UserDb {
    public boolean insertBusRecord(Bus bus) throws SQLException{
        String Query = "insert into bus values('"+bus.getBusID()+"','"+bus.getBoardingPoint()+"','"+bus.getDroppingPoint()+"','"+bus.getDepartureTime()+"','"+bus.getArrivalTime()+"','"+bus.getPrice()+"')";
        return statement.execute(Query);
    }
    public boolean deleteBusRecord(String busID) throws SQLException{
        String Query = "delete from bus where busID = '"+busID+"'";
        return statement.execute(Query);
    }

    public Bus getBusRecord(String busID) throws SQLException{
        String Query = "select * from bus where busID = '"+busID+"'";
        rs = statement.executeQuery(Query);
        if(!rs.next())return null;
        Bus bus = new Bus(rs.getString("busID"),rs.getString("boardingPoint"),rs.getString("droppingPoint"),rs.getString("departureTime"),rs.getString("arrivalTime"),rs.getString("price"));
        return bus;
    }

    public boolean updateBusRecord(Bus bus) throws SQLException{
        String Query = "update bus set boardingPoint = '"+bus.getBoardingPoint()+"',droppingPoint = '"+bus.getDroppingPoint()+"',departureTime = '"+bus.getDepartureTime()+"',arrivalTime = '"+bus.getArrivalTime()+"',price = '"+bus.getPrice()+"' where busID = '"+bus.getBusID()+"'";
        return statement.execute(Query);
    }

    public boolean updateBusTicketPrice(String busID,String newPrice) throws SQLException{
        String Query = "update bus set price = '"+newPrice+"'' where busID = '"+busID+"'";
        return statement.execute(Query);
    }
}
