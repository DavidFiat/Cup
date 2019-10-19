import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.*;

class ParticipantTest {

	private Participant participant1;

	@Test
	private void setupStage() {
		String ID = "1";
		String firstName = "David";
		String lastName = "Fiat";
		String email = "davidfiat";
		String gender = "Male";
		String country = "Colombia";
		String photo = "S";
		String birthday = "24/11/2001";
		participant1 = new Participant(ID, firstName, lastName, email, gender, country, photo, birthday);

		ID = "2";
		firstName = "camilo";
		lastName = "Ramirez";
		email = "cemiloramirez";
		gender = "Male";
		country = "Peru";
		photo = "S";
		birthday = "22/09/2000";

		Participant participant2 = new Participant(ID, firstName, lastName, email, gender, country, photo, birthday);
		try {
			participant1.addParticipant(participant2);
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

		Participant participant3 = new Participant(ID, firstName, lastName, email, gender, country, photo, birthday);
		try {
			participant1.addParticipant(participant3);
		} catch (RepeatedParticipantException e) {
			fail("The participant must be added");
		}
	}

	@Test
	public void searchTest() {
		setupStage();

		//Searching an inexistent Participant
		String ID = "12";
		participant1.search(ID);
		assertNull(participant1.search(ID));

		// Searching one it does exist
		ID = "1";
		participant1.search(ID);
		assertEquals("David", participant1.getFirstName());
		assertEquals("Fiat", participant1.getLastName());
	}
}
