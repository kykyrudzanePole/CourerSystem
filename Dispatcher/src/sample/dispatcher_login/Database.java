package sample.dispatcher_login;

import java.sql.*;
/*
    This class make connection with Database worker and table dispatchers
    AND
 */
public class Database{
    // Create connection:

    Connection con;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
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
    // take password and login from table dispatcher:
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
