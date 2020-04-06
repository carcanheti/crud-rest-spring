package br.com.movie.enums;

public enum Gender {

	MALE(1,"MALE"),
	FEMALE(2,"FEMALE");
	
	private int value;
	private String gender;

	private Gender(int value, String gender) {
		this.value = value;
		this.gender = gender;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getGender() {
		return gender;
	}
}
