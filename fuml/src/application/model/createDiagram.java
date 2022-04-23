package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class createDiagram {

	
	
//Variables Function
public static ArrayList<String> variables(String fileName){
		//Array
		ArrayList<String> variables = new ArrayList<String>();
	   
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
						//skip the line if it is a method
					}
					else if(line.contains("int") || line.contains("String")||line.contains("Boolean")||line.contains("boolean")||line.contains("integer")||line.contains("double")||line.contains("float")) {                                               
						line = line.replaceAll("[^\\[public\\|private\\|protected\\] \\[String\\|int\\|Boolean\\|boolean\\|integer\\|double\\|float\\] \\[A-Za-z\\]*]", "");
					
						line = line.replaceAll("public", "+");
						line = line.replaceAll("private", "-");
						line = line.replaceAll("protected", "*");
						
						String[] words = line.split(" ");
						if(words.length >= 3) {
							for (int i = 3; i < words.length; i++) {
								words[2] = words[2] + " " + words[i];
							}
							line = words[0] + " " +  words[2]+": " +words[1];
							variables.add(line);
						}

						}
				}
				line = reader.readLine();
			}

		
			

		 
			   } catch (IOException e) {                                   

			  e.printStackTrace();                                    
		 }
		
		return variables;
	}
	


//Methods Function
public static ArrayList<String> methods(String fileName){
		//Array
		ArrayList<String> methods = new ArrayList<String>();
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
						line = line.replaceAll("public", "+");
						line = line.replaceAll("private", "-");
						line = line.replaceAll("protected", "*");
						line = line.replaceAll("throws IOException", "");
						line = line.replaceAll("throws FileNotFoundException IOException","");
						String[] words = line.split(" ");
						if(words.length >= 3) {
							for (int i = 3; i < words.length; i++) {
								words[2] = words[2] + " " + words[i];
							}
						}
						line = words[0] + " " +  words[2]+": " +words[1];
						methods.add(line);
					}
				}
				line = reader.readLine();
			}

		
			

		 
			   } catch (IOException e) {                                   

			  e.printStackTrace();
				
								 }									
		return methods;
}
}