package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
    This class make connection with Request_dispatchers: worker and Table: dispatchers

 */
public class Database  {
    // Create connection:

    Connection con;
    protected Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/worker?useSSL=false";
        String user = "root";
        String password = "orest28"; // the first password

        /* As we work together we have two difernt passwords,
            so it's one of the way to get around this problem;
         */
        try{
            con = DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            password = "zakhar99"; // the second password;
            con = DriverManager.getConnection(url,user,password);
        }
        return con;
    }
}
