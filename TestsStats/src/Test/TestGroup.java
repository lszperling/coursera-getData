package Test;

import static org.junit.Assert.*;
import model.Group;
import model.Vote;

import org.junit.Test;

public class TestGroup {

	@Test
	public void testAddVote() {
		Group group = new Group("MERCOSUR");
		String pais = "ARGENTINA";
		String country = "CHINA";
		group.addMember(pais);
		String voto = "Y ";
		Vote vote = new Vote(voto, pais);
		assertTrue(group.getVotes().size() == 0);
		group.addVote(vote);
		assertTrue(group.getVotes().size() == 1);
		Vote falseVote = new Vote(voto, country);
		group.addVote(falseVote);
		assertTrue(group.getVotes().size() == 1);
	}

}
