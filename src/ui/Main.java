package ui;

import model.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

	private Inscribed inscribed;
	private Scanner reader;

	public Main() throws IOException {

		reader = new Scanner(System.in);
		System.out.println("Please enter file´s relative path");
		String file = "";
		boolean exist = false;
		while (!exist) {
			file = reader.nextLine();
			if (new File(file).exists()) {
				exist = true;
			}
		}
		try {
			inscribed = new Inscribed(file);
		} catch (RepeatedSpectatorException a) {
		} catch (RepeatedParticipantException a) {
		}

	}

	public static void main(String[] args) {
		Main m = null;
		try {
			m = new Main();
		} catch (IOException a) {
			a.printStackTrace();
		}
		m.showMenu();
	}

	public void showMenu() {

		int option = 0;
		while (option != 5) {
			System.out.println(" Welcome To PanAmerican women's volleyball cup MANAGEMENT SOFTWARE.");
			System.out.println(" 1.To register an spectator data.");
			System.out.println(" 2.To search for an spectator already registered.");
			System.out.println(" 3.To search for a participant already registered.");
			System.out.println(" 4.To show the structure of a specific country.");
			System.out.println(" 5.To exit.");

			try {
				option = reader.nextInt();
				reader.nextLine();
			} catch (InputMismatchException a) {
				reader.nextLine();
				System.out.println("Please type a correct option.");
			}
			switch (option) {

			case (1):
				addSpectator();
				break;
			case (2):
				searchSpectator();
				break;
			case (3):
				searchParticipant();
				break;
//			case (4):
//				break;
			case (5):
				System.out.println("Goodbye");
				break;
			case (7):
				addParticipant();
				break;
			}
		}
	}

	private void addSpectator() {
		System.out.println("Spectator ID");
		String ID = reader.nextLine();
		System.out.println("First name:");
		String firstName = reader.nextLine();
		System.out.println("Last name:");
		String lastName = reader.nextLine();
		System.out.println("Email:");
		String email = reader.nextLine();
		System.out.println("Gender:");
		String gender = reader.nextLine();
		System.out.println("Country:");
		String country = reader.nextLine();
		System.out.println("Photo:");
		String photo = reader.nextLine();
		System.out.println("birthday:");
		String birthday = reader.nextLine();
		try {
			inscribed.addSpectator(ID, firstName, lastName, email, gender, country, photo, birthday);
			System.out.println("Spectator registered.");
		} catch (RepeatedSpectatorException a) {
			System.out.println("A Spectator with ID " + ID + " already exists.");
		}
	}

	private void searchSpectator() {
		long t = System.currentTimeMillis();
		System.out.println("Please type spectator ID");
		String ID = reader.nextLine();
		if (inscribed.search(ID) == null) {
			System.out.println("Spectator not found");
		} else {
			System.out.println(inscribed.search(ID));
		}
		long t2 = System.currentTimeMillis();
		double time = (double) (t2 - t);
		System.out.println(
				"The time it took for the software to  search the spectator was: " + time + " " + "MilliSeconds");
	}

	private void searchParticipant() {
		long t = System.currentTimeMillis();
		System.out.println("Please type participant ID");
		String ID = reader.nextLine();
		if (inscribed.searchParticipant(ID) == null) {
			System.out.println("Participant not found");
		} else {
			System.out.println(inscribed.searchParticipant(ID));
		}
		long t2 = System.currentTimeMillis();
		double time = (double) (t2 - t);
		System.out.println(
				"The time it took for the software to  search the participant was: " + time + " " + "MilliSeconds");
	}

	private void addParticipant() {
		System.out.println("Participant ID");
		String ID = reader.nextLine();
		System.out.println("First name:");
		String firstName = reader.nextLine();
		System.out.println("Last name:");
		String lastName = reader.nextLine();
		System.out.println("Email:");
		String email = reader.nextLine();
		System.out.println("Gender:");
		String gender = reader.nextLine();
		System.out.println("Country:");
		String country = reader.nextLine();
		System.out.println("Photo:");
		String photo = reader.nextLine();
		System.out.println("birthday:");
		String birthday = reader.nextLine();
		try {
			inscribed.addParticipant(ID, firstName, lastName, email, gender, country, photo, birthday);
			System.out.println("Participant registered.");
		} catch (RepeatedParticipantException a) {
			System.out.println("A Participant with ID " + ID + " already exists.");
		}
	}

}
