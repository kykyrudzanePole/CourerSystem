package sample.dispatcher_login;

import java.sql.*;

public class Database{
    Connection con;
    public Connection getDbConnection()

            throws ClassNotFoundException, SQLException{
        String url = "jdbc:mysql://127.0.0.1:3306/worker?useSSL=false";
        String user = "root";
        String password = "orest28";
        try{
            con = DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            password = "zakhar99";
            con = DriverManager.getConnection(url,user,password);
        }

        return con;
    }
    public ResultSet getUser(Dispatcher dispatcher){
        ResultSet rs = null;
        String select = "SELECT *FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_ID + "=? AND " + Const.USERS_PASSWORD + "=?";
        try{
            PreparedStatement prSt2 = getDbConnection().prepareStatement(select);
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
