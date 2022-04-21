package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class createDiagram {
//create an array list for methods and variables


	public static void create(String fileName){
        ArrayList<String> methods = new ArrayList<String>();
        ArrayList<String> variables = new ArrayList<String>();
	   File file = new File(fileName);
	    BufferedReader reader;
	    try {
	        reader = new BufferedReader(new FileReader(fileName));
	        String line = reader.readLine();
	        while (line != null) {
	            //if the line contain public private or protected
	            if (line.contains("public") || line.contains("private") || line.contains("protected")) {
	            	if(line.contains("(")) {
	            		line = line.replaceAll("[^\\[public\\|private\\|protected\\] String \\[A-Za-z()\\]*]", "");
                        //add line to the array list
                            methods.add(line);

                     
	            	}
	            	//else if
                else if(line.contains("String")) {                                               
	            	line = line.replaceAll("[^\\[public\\|private\\|protected\\] String \\[A-Za-z\\]*]", "");
                    	variables.add(line);
	                }

	            }

	                        
	            line = reader.readLine();
	        }
            //print the array list starting with Variables
            System.out.println("Variables");
            for(int i = 0; i < variables.size(); i++) {
                System.out.println(variables.get(i));
            }
            System.out.println("Methods");
            for(int i = 0; i < methods.size(); i++) {
                System.out.println(methods.get(i));
            }
                                } catch (IOException e) {                                   

                                                    e.printStackTrace();                                    
                                                }

                                                        }                               
}