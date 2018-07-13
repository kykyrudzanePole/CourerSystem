package sample.calls_registration;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Controller for RegistrationView.fxml we write here logic
 */

public class RegistrationController {
    //code copy from sceane builder
    @FXML
    private TextField startadress_field;

    @FXML
    private TextField phone_field;

    @FXML
    private TextField endadress_field;

    @FXML
    private TextField fullname_field;

    @FXML
    private Button registrate_button;

    @FXML
    private Button back_button;

    @FXML
    private Label ername_field;

    @FXML
    private Label erstartadress_field;

    @FXML
    private Label erendadress_field;

    @FXML
    private Label erphone_field;

    @FXML
    void  initialize(){
        // if we press button registration
        registrate_button.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                boolean flag = true;                               // create flag for error checking

                String startadress = startadress_field.getText();  // create 4 changes for textfields
                String endadress = endadress_field.getText();
                String phone = phone_field.getText();
                String fullname = fullname_field.getText();

                // create array from 4 label which will show errors
                Label [] errorShow_mas = {ername_field, erstartadress_field, erendadress_field, erphone_field};

                //create array from textfields for simply work
                String [] textfields = {fullname, startadress, endadress, phone};

                // cicle which check empty textfields
                for(int i = 0; i < textfields.length; i++){
                    if(textfields[i].length() == 0){
                        errorShow_mas[i].setText("Write some values");
                    }
                }
                // for right name
                if(textfields[0].length() < 2) {
                    flag = false;
                    errorShow_mas[0].setText("wrong name");
                }
                // for right phone number
                if(textfields[3].length() != 10){
                    flag = false;
                    errorShow_mas[3].setText("wrong phone");
                }else{
                    // using regex to check that it is all number in the phone textfield
                    Pattern pattern = Pattern.compile("\\D");
                    Matcher matcher = pattern.matcher(textfields[3]);
                    while (matcher.find()){
                        flag = false;
                        errorShow_mas[3].setText("only numbers");
                    }
                }
                if(flag){       // using flag
                    // create references on class Populate_dispatcherCalls and give array with values in textfields
                   Populate_dispatcherCalls populate = new Populate_dispatcherCalls(textfields);
                   // And finally call method which add values to the database
                    try {
                        populate.populateTable();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
