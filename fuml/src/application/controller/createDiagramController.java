package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class createDiagramController {

    @FXML
    private ListView<String> listedFile;
    
    @FXML
    private AnchorPane mainPane;
    
    @FXML
    private MenuBar menuBar;
    
    
    //Displays Pop up of functions on application
    @FXML
    void aboutHelp(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/Help.fxml").toURI().toURL();
    	Scene scene = new Scene(FXMLLoader.load(url));
    	Stage window = new Stage();
    	window.setScene(scene);
        window.show();
    }
    
    @FXML
    void Generate(ActionEvent event) throws IOException{

    }
    
    // returns user to home page
    @FXML
    void returnHome(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/Main.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) menuBar.getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    @FXML
    void uploadFile(ActionEvent event) throws IOException{

    }

}
