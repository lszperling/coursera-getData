package Test;
import static org.junit.Assert.*;
import model.Vote;
import model.VoteFilter;

import org.junit.Test;

public class TestFilterVotes {

	@Test
	public void testFilterAbstention() {
		VoteFilter filter = new VoteFilter();
		String coso = "A puto";
		Vote voto = filter.filterLine(coso);
		assertTrue(voto.getCountry().compareTo("puto") == 0);
		assertTrue(voto.getVote().compareTo("A ") == 0);
	}

	public void testFilterYes() {
		VoteFilter filter = new VoteFilter();
		String coso = "Y puto";
		Vote voto = filter.filterLine(coso);
		assertTrue(voto.getCountry().compareTo("puto") == 0);
		assertTrue(voto.getVote().compareTo("Y ") == 0);
	}

	public void testFilterNo() {
		VoteFilter filter = new VoteFilter();
		String coso = "N puto";
		Vote voto = filter.filterLine(coso);
		assertTrue(voto.getCountry().compareTo("puto") == 0);
		assertTrue(voto.getVote().compareTo("N ") == 0);
	}

	public void testFilterNotIncluded() {
		VoteFilter filter = new VoteFilter();
		String coso = "Y puto";
		Vote voto = filter.filterLine(coso);
		assertTrue(voto == null);
	}

}
