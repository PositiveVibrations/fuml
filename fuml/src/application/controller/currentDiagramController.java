package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import application.model.currentDiagram;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class currentDiagramController {
	
	@FXML
	AnchorPane anchorPane;
	
	@FXML
    private MenuBar menuBar;
	
	public static String projectName;
	Random rand = new Random();
	
	
	 @FXML
	 void aboutHelp(ActionEvent event) throws IOException{
	    URL url = new File("src/application/view/Help.fxml").toURI().toURL();
	    Scene scene = new Scene(FXMLLoader.load(url));
	    Stage window = new Stage();
	    window.setScene(scene);
	    window.show();
	 }
	
	@FXML
    void returnHome(ActionEvent event) throws IOException{
		URL url = new File("src/application/view/Main.fxml").toURI().toURL();
    	anchorPane = FXMLLoader.load(url);
        Scene scene = new Scene(anchorPane);// pane you are GOING TO show
        Stage window = (Stage) menuBar.getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
	
	@FXML
	void initialize () throws IOException{
		
		ArrayList<String> files = new ArrayList<String>();
		currentDiagram currDiagram = new currentDiagram();
		files = currDiagram.obtainFileElements(projectName);
		System.out.println(files);
		for(int i = 0; i < files.size(); i++)
		{
			
			
			int randomNum = rand.nextInt(500)+1;
			

			TextArea textArea = new TextArea();
			textArea.setMaxSize(150.0, 150.0);
			textArea.setText(files.get(i));
			//remove any text from last text area
			
			AnchorPane.setTopAnchor(textArea, (double)randomNum);
			anchorPane.getChildren().add(textArea);
			anchorPane.getChildren().forEach(this::makeDraggable);
			
		}
		
	}

	
	
	// components to allow the nodes to be draggable
    private double startX;
    private double startY;
    
    private void makeDraggable(Node node)
    {
    	node.setOnMousePressed(e -> {
    		startX = e.getSceneX() - node.getTranslateX();
    		startY = e.getSceneX() - node.getTranslateX();
    	});
    	
    	node.setOnMouseDragged(e-> {
    		node.setTranslateX(e.getSceneX() - startX);
    		node.setTranslateY(e.getSceneY() - startY);
    	});
    	
    }
}
