package sample.dispatcher_login;

import sample.Database;
import java.sql.*;

public class Request_dispatchers extends Database {

    public ResultSet getUser(Dispatcher dispatcher){
        ResultSet rs = null;
        // write request to the table using constants from class Const:
        String select = "SELECT *FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_ID + "=? AND " + Const.USERS_PASSWORD + "=?";
        try{
            PreparedStatement prSt2 = getDbConnection().prepareStatement(select); // using request
            prSt2.setString(1,dispatcher.getID_worker());
            prSt2.setString(2,dispatcher.getPassword());
            rs = prSt2.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return rs;
    }
}
