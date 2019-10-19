import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class InscribedTest {

	private Inscribed inscribed1;

	@Test
	private void setupStage() {
		inscribed1 = new Inscribed();
		String ID = "1";
		String firstName = "David";
		String lastName = "Fiat";
		String email = "davidfiat";
		String gender = "Male";
		String country = "Colombia";
		String photo = "S";
		String birthday = "24/11/2001";
		try {
			inscribed1.addParticipant(ID, firstName, lastName, email, gender, country, photo, birthday);
		} catch (RepeatedParticipantException e) {
			fail("The participant must be added");
		}
		ID = "2";
		firstName = "camilo";
		lastName = "Ramirez";
		email = "cemiloramirez";
		gender = "Male";
		country = "Peru";
		photo = "S";
		birthday = "22/09/2000";
		try {
			inscribed1.addParticipant(ID, firstName, lastName, email, gender, country, photo, birthday);
		} catch (RepeatedParticipantException e1) {
			fail("The participant must be added");
		}

		ID = "3";
		firstName = "Mariana";
		lastName = "Dorado";
		email = "marianadorado";
		gender = "Female";
		country = "China";
		photo = "N";
		birthday = "10/08/1999";

		try {
			inscribed1.addParticipant(ID, firstName, lastName, email, gender, country, photo, birthday);
		} catch (RepeatedParticipantException e1) {
			fail("The participant must be added");

		}
		ID = "3";
		firstName = "Johnatan";
		lastName = "Pelaez";
		email = "johnatanpelaez";
		gender = "Male";
		country = "Japon";
		photo = "N";
		birthday = "24/11/2001";
		try {
			inscribed1.addSpectator(ID, firstName, lastName, email, gender, country, photo, birthday);
		} catch (RepeatedSpectatorException e) {
			fail("The spectator must be added");
		}
		
		
		ID = "4";
		firstName = "Camila";
		lastName = "Fiat";
		email = "camilafiat";
		gender = "Female";
		country = "Chile";
		photo = "S";
		birthday = "24/11/2001";
		try {
			inscribed1.addSpectator(ID, firstName, lastName, email, gender, country, photo, birthday);
		} catch (RepeatedSpectatorException e) {
			fail("The spectator must be added");
		}
		ID = "5";
		firstName = "Martin";
		lastName = "Lorza";
		email = "Lorzamartin";
		gender = "Male";
		country = "Ecuador";
		photo = "N";
		birthday = "03/03/2003";
		try {
			inscribed1.addSpectator(ID, firstName, lastName, email, gender, country, photo, birthday);
		} catch (RepeatedSpectatorException e1) {
			fail("The spectator must be added");
		}

		ID = "2";
		firstName = "Fernanda";
		lastName = "Colorado";
		email = "fcolorado";
		gender = "Female";
		country = "Venezuela";
		photo = "Ay";
		birthday = "04/11/1999";

		try {
			inscribed1.addSpectator(ID, firstName, lastName, email, gender, country, photo, birthday);
		} catch (RepeatedSpectatorException e1) {
			fail("The spectator must be added");
		}

	}

	@Test
	public void searchPTest() {
		setupStage();

		// Searching an inexistent Participant
		String ID = "12";
		inscribed1.searchParticipant(ID);
		assertNull(inscribed1.searchParticipant(ID));

		// Searching one it does exist at the first position
		ID = "1";
		inscribed1.searchParticipant(ID);
		assertEquals("David", inscribed1.searchParticipant(ID).getFirstName());
		assertEquals("Fiat", inscribed1.searchParticipant(ID).getLastName());

		// Searching one it does exist at other position
		ID = "3";
		inscribed1.searchParticipant(ID);
		assertEquals("Mariana", inscribed1.searchParticipant(ID).getFirstName());
		assertEquals("Dorado", inscribed1.searchParticipant(ID).getLastName());
	}

	@Test
	public void searchTest() {
		setupStage();

		// Searching an inexistent Participant
		String ID = "24";
		inscribed1.search(ID);
		assertNull(inscribed1.search(ID));

		// Searching one it does exist at the first position
		ID = "2";
		inscribed1.search(ID);
		assertEquals("Fernanda", inscribed1.search(ID).getFirstName());
		assertEquals("Colorado", inscribed1.search(ID).getLastName());

		// Searching one it does exist at other position
		ID = "4";
		inscribed1.search(ID);
		assertEquals("Camila", inscribed1.search(ID).getFirstName());
		assertEquals("Fiat", inscribed1.search(ID).getLastName());
	}
	@Test
	public void addSpectatorTest() {
		setupStage();
		inscribed1.getOriginSpectator().getFirstName().equals("Johnatan");
		inscribed1.getOriginSpectator().getLeftSpectator().getFirstName().equals("Fernanda");
		inscribed1.getOriginSpectator().getRightSpectator().getFirstName().equals("Camila");

	
	}


}
