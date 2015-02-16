package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserVotes {

	public ArrayList<Vote> parsear(String fileName)
			throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		VoteFilter filter = new VoteFilter();
		ArrayList<Vote> votes = new ArrayList<Vote>();
		try {
			while ((line = br.readLine()) != null) {
				if (filter.filterLine(line) != null)
					votes.add(filter.filterLine(line));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return votes;
	}
}
