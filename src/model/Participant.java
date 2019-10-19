package model;

public class Participant {

	private String ID;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthday;
	private Participant next;
	private Participant previous;

	public Participant(String ID, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthday) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Participant getNext() {
		return next;
	}

	public void setNext(Participant next) {
		this.next = next;
	}

	public Participant getPrevious() {
		return previous;
	}

	public void setPrevious(Participant previous) {
		this.previous = previous;
	}

	public int compareTo(Participant a) {
		return ID.compareTo(a.getID());
	}

	public void addParticipant(Participant a) throws RepeatedParticipantException {

		if (compareTo(a) == 0) {
			throw new RepeatedParticipantException(a.getID());
		} else {
			if (next == null) {
				setNext(a);
				next.setPrevious(this);
			} else {
				next.addParticipant(a);
			}
		}

	}

	public Participant search(String ID) {
		if (this.ID.compareTo(ID) == 0) {
			return this;
		} else {
			return (next == null) ? null : next.search(ID);

		}
	}

	public Participant searchIterative(String ID) {
		Participant a = null;
		Participant nex = this;
		boolean finded = false;
		while (nex != null && !finded) {
			if (nex.ID.compareTo(ID) == 0) {
				a = nex;
				finded = true;
				return a;

			} else {
				if (nex.getNext() == null) {
					return null;
				} else {
					nex = nex.getNext();

				}
			}
		}
		return a;
	}
	


	@Override
	public String toString() {
		return "Participant [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", country=" + country + ", photo=" + photo + ", birthday=" + birthday + "]";
	}

	public void addParticipantIterative(Participant a) throws RepeatedParticipantException {
		Participant nex = this;

		while (nex != null) {

			if (compareTo(a) == 0) {
				throw new RepeatedParticipantException(a.getFirstName());
			} else {
				if (nex.getNext() == null) {
					nex.setNext(a);
					a.setPrevious(nex);
					nex = null;
				} else {
					nex = nex.getNext();
				}
			}

		}
	}

}
