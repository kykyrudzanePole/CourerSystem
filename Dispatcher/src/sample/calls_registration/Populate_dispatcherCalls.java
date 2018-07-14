package sample.calls_registration;

import sample.Database;

import java.sql.SQLException;
import java.sql.Statement;

import static sample.calls_registration.Const.*;        // using static import, because all constant are static

/*
    This class we use to create values in table dispatcher_calls
    in this class code for SQL
 */

public class Populate_dispatcherCalls extends Database {

    String startadress;        // values which we will use to populate the colum
    String endadress;
    String phone;
    String fullname;

    public void populateTable() throws SQLException {
        long orderID = 1000000;  // create in order to find call using ID
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();

            // write scrip for sql, this scrip write date to the database

            statement.executeUpdate("insert into " + "worker" + ".dispatcher_calls" +
                    " values('"+fullname+"', '"+startadress+"', '"+endadress+"', '"+phone+"', '"+orderID+"')");
            orderID++;   // just increment ID

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Populate_dispatcherCalls(String[] textfields) {     // take array with values from worker window

        fullname = textfields[0];
        startadress = textfields[1];
        endadress = textfields[2];
        phone = textfields[3];
    }
}

