import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.*;

class SpectatorTest {

	private Spectator spectator1;

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
		spectator1 = new Spectator(ID, firstName, lastName, email, gender, country, photo, birthday);

		ID = "2";
		firstName = "camilo";
		lastName = "Ramirez";
		email = "cemiloramirez";
		gender = "Male";
		country = "Peru";
		photo = "S";
		birthday = "22/09/2000";

		Spectator spectator2 = new Spectator(ID, firstName, lastName, email, gender, country, photo, birthday);
		try {
			spectator1.addSpectator(spectator2);
		} catch (RepeatedSpectatorException e1) {
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

		Spectator spectator3 = new Spectator(ID, firstName, lastName, email, gender, country, photo, birthday);
		try {
			spectator1.addSpectator(spectator3);
		} catch (RepeatedSpectatorException e) {
			fail("The participant must be added");
		}
	}

	@Test
	public void searchPTest() {
		setupStage();

		//Searching an inexistent Spectator
		String ID = "12";
		spectator1.search(ID);
		assertNull(spectator1.search(ID));

		// Searching one it does exist
		ID = "2";
		spectator1.search(ID);
		assertEquals("camilo", spectator1.search(ID).getFirstName());
		assertEquals("Ramirez", spectator1.search(ID).getLastName());
	}
}
