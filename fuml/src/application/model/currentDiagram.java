package application.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class currentDiagram {

	/*returns arrayList containing elements in file
	 * reads diagramHistory to parse project
	 */
	public ArrayList<String> obtainFileElements(String project){
		ArrayList<String> elements = new ArrayList<String>();
		int read = 0;
		String fileInfo = "";
		
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("src/diagramHistory.txt"));
			String line = reader.readLine();
			
			while (line != null) {
	
				if(line.equals("Project: "+project)){

					read = 1;
				}
				
				if(read == 1){
					fileInfo = fileInfo+line+"\n";
					
				}
				
				if(line.equals("}") && read == 1) {
					fileInfo = fileInfo+line+"\n\n";
					elements.add(fileInfo);
					fileInfo="";
					

					
				}
				if(line.equals("")) {
					read = 0;
					
				}
				
				line = reader.readLine();
				
			}
				
			reader.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return elements;	
	}

}