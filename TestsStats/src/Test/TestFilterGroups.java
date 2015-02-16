package Test;

import java.util.Collection;
import java.util.LinkedList;

import model.Group;
import model.ParserGroups;

import org.junit.Test;

public class TestFilterGroups extends IntegrationTest {

	@Test
	public void testCountries() {
		ParserGroups parser = new ParserGroups();
		String fileName = "C:/Users/Leonel/Desktop/Lista_de_invitacion.csv";
		Collection<Group> groups = new LinkedList<Group>();
		for (Group group : groups) {
			System.out.println(group.toString());
			
		}
	}

}
