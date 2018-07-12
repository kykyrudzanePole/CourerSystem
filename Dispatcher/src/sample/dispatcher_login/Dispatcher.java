package sample.dispatcher_login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dispatcher {
    private String ID_worker;
    private String password;

    public Dispatcher(String ID_worker, String password) {
        this.ID_worker = ID_worker;
        this.password = password;
    }

    public Dispatcher() { }

    public String getID_worker() {
        return ID_worker;
    }

    public void setID_worker(String ID_worker) {
        this.ID_worker = ID_worker;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Main extends Application {
        @Override
        public void start(Stage primaryStage) {
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("OfficeView.fxml"));
                primaryStage.setTitle("Dispatcher");
                primaryStage.setScene(new Scene(root, 700, 400));
                primaryStage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) {
            launch(args);
        }
    }
}
