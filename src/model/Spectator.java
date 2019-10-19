package model;

public class Spectator {

	private String ID;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthday;
	private Spectator leftSpectator;
	private Spectator rightSpectator;

	public Spectator(String ID, String firstName, String lastName, String email, String gender, String country,
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

	public Spectator getLeftSpectator() {
		return leftSpectator;
	}

	public void setLeftSpectator(Spectator leftSpectator) {
		this.leftSpectator = leftSpectator;
	}

	public Spectator getRightSpectator() {
		return rightSpectator;
	}

	public void setRightSpectator(Spectator rightSpectator) {
		this.rightSpectator = rightSpectator;
	}

	public int compareTo(Spectator a) {
		return ID.compareTo(a.getID());
	}

	public void addSpectator(Spectator a) throws RepeatedSpectatorException {

		if (compareTo(a) == 0)
			throw new RepeatedSpectatorException(a.getID());

		if (compareTo(a) > 0) {
			if (leftSpectator == null)
				leftSpectator = a;
			else
				leftSpectator.addSpectator(a);
		} else {
			if (rightSpectator == null)
				rightSpectator = a;
			else
				rightSpectator.addSpectator(a);

		}
	}

	public Spectator search(String ID) {
		if (this.ID.compareTo(ID) == 0) {
			return this;
		} else if (this.ID.compareTo(ID) > 0) {
			return (leftSpectator == null) ? null : leftSpectator.search(ID);

		} else {
			return (rightSpectator == null) ? null : rightSpectator.search(ID);

		}

	}

	@Override
	public String toString() {
		return "Spectator [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", country=" + country + ", photo=" + photo + ", birthday=" + birthday + "]";
	}

}
