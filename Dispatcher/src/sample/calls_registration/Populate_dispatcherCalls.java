package sample.calls_registration;

import sample.Database;

import java.sql.SQLException;
import java.sql.Statement;

/*
    This class we use to create values in table dispatcher_calls
    in this class code for SQL
 */

public class Populate_dispatcherCalls extends Database {

    public void populateTable() throws SQLException {
        Statement statement = null;
        statement = con.createStatement();
    }
}
