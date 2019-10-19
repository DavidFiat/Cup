package model;

import java.io.*;

public class Inscribed {

	private Participant firstParticipant;
	private Spectator originSpectator;
	private String file;

	public Inscribed(String file) throws IOException, RepeatedSpectatorException, RepeatedParticipantException {
		this.file = file;
		loadData();

	}

	public Inscribed() {
	}

	public Participant getFirstParticipant() {
		return firstParticipant;
	}

	public void setFirstParticipant(Participant firstParticipant) {
		this.firstParticipant = firstParticipant;
	}

	public Spectator getOriginSpectator() {
		return originSpectator;
	}

	public void setOriginSpectator(Spectator originSpectator) {
		this.originSpectator = originSpectator;
	}

	public void addSpectator(String ID, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthday) throws RepeatedSpectatorException {
		Spectator a = new Spectator(ID, firstName, lastName, email, gender, country, photo, birthday);
		if (originSpectator == null)
			setOriginSpectator(a);
		else
			originSpectator.addSpectator(a);
	}

	public Spectator search(String ID) {
		return originSpectator == null ? null : originSpectator.search(ID);
	}

	public void addParticipant(String ID, String firstName, String lastName, String email, String gender,
			String country, String photo, String birthday) throws RepeatedParticipantException {
		Participant a = new Participant(ID, firstName, lastName, email, gender, country, photo, birthday);
		if (firstParticipant == null)
			setFirstParticipant(a);
		else {
			
			//The method should be used iteratively to avoid stackOverFlowError
			firstParticipant.addParticipantIterative(a);
		}
	}

	public Participant searchParticipant(String ID) {
		return firstParticipant == null ? null : firstParticipant.searchIterative(ID);

	}

	public void loadData() throws IOException {
		File f = new File(file);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = "";
		while ((line = br.readLine()) != null) {
			if (!line.equals("id,first_name,last_name,email,gender,country,photo,birthday")) {
				String[] s = line.split(",");
				try {
					addSpectator(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
				} catch (RepeatedSpectatorException e) {
				}
				if ((int) (Math.random() * 2) == 0) {
					try {
						addParticipant(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
					} catch (RepeatedParticipantException e) {
					}
				}

			}
		}

		br.close();
	}

}
