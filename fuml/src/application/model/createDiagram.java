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

	    File file = new File(fileName);
	    BufferedReader reader;
	    try {
	        reader = new BufferedReader(new FileReader(fileName));
	        String line = reader.readLine();
	        while (line != null) {
	           
	            if (line.contains("public") || line.contains("private") || line.contains("protected")) {
	                System.out.println(line);
	                }
	            line = reader.readLine();
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
	