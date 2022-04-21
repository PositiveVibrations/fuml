package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class createDiagram {


	public static void create(String fileName){
		//Arrays
        ArrayList<String> methods = new ArrayList<String>();
        ArrayList<String> variables = new ArrayList<String>();
	   File file = new File(fileName);
	    BufferedReader reader;
	    try {
	        reader = new BufferedReader(new FileReader(fileName));
	        String line = reader.readLine();
	        while (line != null) {
				//remove extra spaces between words
				line = line.replaceAll("\\s+", " ");
	            //if the line contain public private or protected
	            if (line.contains("public") || line.contains("private") || line.contains("protected")) {
	            	if(line.contains("(")) {
	            		line = line.replaceAll("[^\\[public\\|private\\|protected\\] \\[A-Za-z<>()]*", "");
                    	methods.add(line);
	            		//Pattern pattern = Pattern.compile(".*(public [void|String]+ [A-Za-z( ]*\\)).*");
	            		//next going to be using this system to extract to correct UML format text from arraylist
	            		//Matcher matcher = pattern.matcher(line);
	            		//if (matcher.find())
	            		//{
	            			//methods.add(matcher.group(1));
	            	//}
	            		
	            	}
	            	//else if
                else if(line.contains("int") || line.contains("String")||line.contains("Boolean")||line.contains("boolean")||line.contains("integer")||line.contains("double")||line.contains("float")) {                                               
	            	line = line.replaceAll("[^\\[public\\|private\\|protected\\] \\[String\\|int\\|Boolean\\|boolean\\|integer\\|double\\|float\\] \\[A-Za-z\\]*]", "");
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