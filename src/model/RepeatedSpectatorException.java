package model;

public class RepeatedSpectatorException extends Exception {

	public RepeatedSpectatorException(String a) {
		super("There is already a Spectator with ID: " + a);
	}

}
