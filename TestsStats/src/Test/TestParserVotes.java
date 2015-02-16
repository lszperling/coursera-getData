package Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import model.ParserVotes;
import model.Vote;

import org.junit.Test;

public class TestParserVotes {

	@Test
	public void test() {
		ParserVotes parser = new ParserVotes();
		String fileName = "C:/Users/Leonel/Desktop/resol1.txt";
		try {
			ArrayList<Vote> votos = parser.parsear(fileName);
			for (Vote vote : votos) {
				System.out.println(vote.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
