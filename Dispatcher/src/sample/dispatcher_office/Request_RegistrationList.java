/*
package sample.dispatcher_office;

import sample.Database;
import sample.dispatcher_login.Const;
import sample.dispatcher_login.Dispatcher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Request_RegistrationList extends Database {
    public ResultSet getTable(Customer_data){
        ResultSet rs = null;
        // write request to the table using constants from class Const:
        String select = "SELECT * FROM dispatchers calls";
        try{
            PreparedStatement prSt2 = getDbConnection().prepareStatement(select); // using request
            prSt2.setString(1,Customer_data.());
            prSt2.setString(2,Customer_data.());
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
*/