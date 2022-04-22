package application.controller;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import application.model.createDiagram;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
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
    //will pass to functions in model later
    void Generate(ActionEvent event) throws IOException{
        ArrayList<String> methods = new ArrayList<String>();
		ArrayList<String> variables = new ArrayList<String>();
        ArrayList<String> fileList = new ArrayList<String>(); 
        for(int i = 0; i < listedFile.getItems().size(); i++){
              fileList.add(listedFile.getItems().get(i));
            //this is the variables arrayList...set it to print for now, use it how you want.
             variables = createDiagram.variables(listedFile.getItems().get(i));
        	 for(int j = 0; j < variables.size(); j++) {
				 System.out.println(variables.get(j));
        	 }
        	 //this is the methods arrayList...set it to print for now, use it how you want.
        	 methods = createDiagram.methods(listedFile.getItems().get(i));
        	 for(int j = 0; j < methods.size(); j++) {
				 System.out.println(methods.get(j));
        	 }
        }
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
    	//if no file is selected then exist without error
		
        FileChooser fc = new FileChooser();
        fc.setTitle("Open Java Files");
      
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Java files (*.java)", "*.java");
        fc.getExtensionFilters().add(extFilter);
      
        File file = fc.showOpenDialog(null);
        if(file != null){
        listedFile.getItems().add(file.getPath());

        }
    }

}
