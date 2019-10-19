package model;

public class RepeatedParticipantException extends Exception {

	public RepeatedParticipantException(String a) {
		super("There is already a Participant with ID: " + a);
	}

}
