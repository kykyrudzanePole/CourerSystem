package sample.dispatcher_office;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.Database;

public class OfficeController extends Database {
    @FXML
    private TableView personTable;
    @FXML
    private Button changeOffice_button;

    @FXML
    private Button callsRegistration_button;

    @FXML
    private Button curlers_button;

    @FXML
    void initialize() {
        callsRegistration_button.setOnAction(new EventHandler<ActionEvent>() {  // Go to calls_registration
            @Override
            public void handle(ActionEvent event) {
                callsRegistration_button.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/calls_registration/RegistrationView.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
            changeOffice_button.setOnAction(new EventHandler<ActionEvent>() {  //Button, which return to LogIn
                @Override
                public void handle(ActionEvent event) {
                    changeOffice_button.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/dispatcher_login/sample.fxml"));
                    try {
                        loader.load();
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
            });
            Database db = new Database();

        }
    }



