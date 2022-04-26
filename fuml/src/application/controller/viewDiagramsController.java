package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import application.model.viewDiagrams;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class viewDiagramsController {

	@FXML
    private AnchorPane mainPane;
	
	@FXML
    private MenuBar menuBar;

	@FXML
    private ChoiceBox<String> choiceBox;
	
	//returns user to home menu
    @FXML
    void returnHome(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/Main.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) menuBar.getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    //displays pop up to aid user
    @FXML
    void aboutHelp(ActionEvent event) throws IOException{
    	URL url = new File("src/application/view/Help.fxml").toURI().toURL();
    	Scene scene = new Scene(FXMLLoader.load(url));
    	Stage window = new Stage();
    	window.setScene(scene);
        window.show();
    }
    
    //reads file and deletes diagram in file
    @FXML
    void deleteDiagram(ActionEvent event) {
    	String project = choiceBox.getValue();
    	viewDiagrams deleteDiagram = new viewDiagrams();
    	deleteDiagram.deleteCurrentDiagram(project);

		Alert error= new Alert(AlertType.CONFIRMATION);
		error.setTitle("Project:" + project+" Deleted Successfull!");
		error.setHeaderText("Successful deletion of "+project);
		error.setContentText("Thanks for Deleting!");
		error.showAndWait();
		
		
    	ArrayList<String> projectNames = new ArrayList<String>();
    	choiceBox.getItems().clear();
    	projectNames = viewDiagrams.obtainProjectNames();
    	
    	for(int i= 0; i < projectNames.size(); i++)
    	{
    		if(!choiceBox.getItems().contains(projectNames.get(i)))
    		{
    		choiceBox.getItems().add(projectNames.get(i));
    		//if sets default value
    		}
    		if(i == 0)
    		{
    			choiceBox.setValue(projectNames.get(i));
    		}
    	}
    	
    }
    
    /*calls viewDiagrams.obtainProjectNames into arrayList
     * arrayList is used to add items to choiceBox
     */
    @FXML
    void initialize() {
    	ArrayList<String> projectNames = new ArrayList<String>();
    	projectNames = viewDiagrams.obtainProjectNames();
    	for(int i= 0; i < projectNames.size(); i++)
    	{
    		//check for duplicates
    		if(!choiceBox.getItems().contains(projectNames.get(i)))
    		{
    			choiceBox.getItems().add(projectNames.get(i));
    		}
    		if(i == 0)
    		{
    			choiceBox.setValue(projectNames.get(i));
    		}
    	}
    	

    	
    }
    }

