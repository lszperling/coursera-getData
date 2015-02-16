package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ParserGroups {

	public Set<String> parsear(String fileName) {
		Set<String> groups = new HashSet<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			try {
				while ((line = br.readLine()) != null) {
					if (line.contains(".java"))
						groups.add(line);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return groups;
	}

}
