package application.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    //write the list to list.txt...will pass to functions in model later
    void Generate(ActionEvent event) throws IOException{
        ArrayList<String> fileList = new ArrayList<String>(); 
        for(int i = 0; i < listedFile.getItems().size(); i++){
              fileList.add(listedFile.getItems().get(i));
        }
        File file = new File("src/list.txt");
       
        for(int i = 0; i < fileList.size(); i++){
            try {
                java.io.FileWriter fw = new java.io.FileWriter(file, true);
                fw.write(fileList.get(i) + "\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
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
    	
        FileChooser fc = new FileChooser();
        fc.setTitle("Open Resource File");
      
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Java files (*.java)", "*.java");
        fc.getExtensionFilters().add(extFilter);
      
        File file = fc.showOpenDialog(null);
   
        listedFile.getItems().add(file.getPath()+file.getName());

        }
}
