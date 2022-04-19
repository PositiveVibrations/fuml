package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

	@FXML
    private AnchorPane mainPane;
	
	@FXML
    private MenuBar menuBar;

	
	
	//displays pop up of application functions, from menuBar
    @FXML
    void resources(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/Help.fxml").toURI().toURL();
    	Scene scene = new Scene(FXMLLoader.load(url));
    	Stage window = new Stage();
    	window.setScene(scene);
        window.show();
    }
	
	//displays viewDiagrams.fxml, from menuBar
	@FXML
    void editUML(ActionEvent event) throws IOException{
		URL url = new File("src/application/view/viewDiagrams.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) menuBar.getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
    
    //displays createDiagram.fxml, from menuBar
    @FXML
    void uploadCode(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/createDiagram.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) menuBar.getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
	
	
	//diplays createDiagram.fxml
    @FXML
    void createNew(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/createDiagram.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    //displays viewDiagram.fxml
    @FXML
    void viewDiagram(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/viewDiagrams.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

}
