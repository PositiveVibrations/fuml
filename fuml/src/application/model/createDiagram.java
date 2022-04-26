package application.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
				line = line.replaceAll("^\\s+", "");
				line = line.replaceAll("$\\s+", "");
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
						if(words.length > 2) {
							for (int i = 3; i < words.length; i++) {
								words[2] = words[2] + " " + words[i];
							}
							line = words[0] + " " + words[2]+": " + words[1];
							variables.add(line);
						}
						else if(words.length==3) {
						line = words[0] + " " + words[2]+": " + words[1] ;
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
				line = line.replaceAll("^\\s+", "");
				line = line.replaceAll("$\\s+", "");
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
						if(words.length > 3) {
							for (int i = 3; i < words.length; i++) {
								words[2] = words[2] + ": " + words[i];
							}
						}
						if(words.length==3) {
						
						line = words[0] + " " + words[2]+": " + words[1];
						methods.add(line);
						}
						else {
							line=line;
							methods.add(line);
						}
					}
				}
				line = reader.readLine();
			}
			
			} catch (IOException e) {                                   

			  e.printStackTrace();
				
			}									
		return methods;
	}

	/*checks diagramHistory if the project already exists
	 * returns boolean file
	 */
	public static boolean checkHistory(String projectName) throws IOException{
		boolean projectExists = false;
				
		BufferedReader reader = new BufferedReader(new FileReader("src/diagramHistory.txt"));
		try {
		    String line;
		    while ((line = reader.readLine()) != null) {
		       if(line.equals("Project: "+projectName))
		       {
		    	   projectExists = true;
		       }
		    }
		    
		} finally {
		    reader.close();
		}
    	
		
		return projectExists;
	}
	
	public static void addDiagramsHistory(ArrayList<String> methods,ArrayList<String> variables,ArrayList<String> fileList,String projectName){
        
		//begins with projectName followed by newline
		try {
			System.out.println(fileList);
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/diagramHistory.txt", true));
			int i=0;
			writer.write("Project: "+projectName+"\n");
			for(i= 0; i < fileList.size(); i++)
			{
				
				
				writer.write("{\nFile: "+fileList.get(i)+"\n");
				//print the array list starting with Variables
				writer.write("Variables:\n");
				for(int j = 0; j < variables.size(); j++) {
					writer.write(variables.get(j)+"\n");
				}
				
				//print array with methods
				writer.write("Methods:\n");
				for(int j = 0; j < methods.size(); j++) {
					writer.write(methods.get(j)+"\n");
				}
				writer.write("}\n");
			}
			//end of protect is seen through /n/n
			writer.write("");
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	}


