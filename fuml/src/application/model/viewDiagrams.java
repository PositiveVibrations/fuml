package application.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class viewDiagrams {

	/*obtainProjectNames()
	 * 		reads diagramHistory and parses project names
	 * returns ArrayList<String>
	 */
	public static ArrayList<String> obtainProjectNames() {
		ArrayList<String> projectNames = new ArrayList<String>();
		
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("src/diagramHistory.txt"));
			String line = reader.readLine();
			while (line != null) {
				if(line.contains("Project: "))
				{
					int length = line.length();
					String project = line.substring(8,length);
					
					projectNames.add(project);
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
		
		return projectNames;
	}

	
	public void deleteCurrentDiagram(String project)
	{
		
		try {
			boolean isFile = false;
			ArrayList<String> file = new ArrayList<String>();
			
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("src/diagramHistory.txt"));
			String line = reader.readLine();
			
			while (line != null) {
				if(line.contains(project) || isFile)
				{
					isFile = true;
				}
				
				if((!line.contains(project) )&& line.contains("Project:")){
					if(isFile)
					{
						isFile = false;
					}
				}
				if(!isFile)
				{
					file.add(line);
				}
				line = reader.readLine();
			}
			reader.close();
			
			//rewrite file with contents
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/diagramHistory.txt"));
			for(int i = 0; i < file.size(); i++)
			{
				writer.write(file.get(i)+"\n");

			}	
			writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}




