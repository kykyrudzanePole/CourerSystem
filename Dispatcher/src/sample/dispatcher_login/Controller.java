package sample.dispatcher_login;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;



import java.io.IOException;
import java.sql.*;

public class Controller {
    @FXML
    private Label Error;
    @FXML
    private TextField TextField1;
    @FXML
    private TextField TextField2;
    @FXML
    private Button button;
    @FXML
    void initialize() {
        button.setOnAction(event -> {
            String id = TextField1.getText().trim();
            String pass = TextField2.getText().trim();
            if(!id.equals("") && !pass.equals(""))
            {
                loginUser(id,pass);
            }
            else{
                System.out.println("ID and password is Empty");
            }
        });
    }

    public void loginUser(String id, String pass){
        Database db = new Database();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setID_worker(id);
        dispatcher.setPassword(pass);
        ResultSet rs = db.getUser(dispatcher);
        int counter = 0;
        try {
            while (rs.next()) {
                counter++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if(counter>=1){
            button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/dispatcher_office/OfficeView.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        }
        else{
            Error.setText("You entered incorrect data, " + "\n" +
                    "please check back" + "\n" + "and fill out the form again");
            Error.setTextAlignment(TextAlignment.CENTER);
        }
    }
}

