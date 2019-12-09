package com.model;

import java.util.LinkedHashMap;
import java.util.List;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	private LinkedHashMap<String, String> countryList;
	private List<String> operatingSystems;
	
	public Student() {
		countryList = new LinkedHashMap<String, String>();
		countryList.put("IN", "India");
		countryList.put("EN", "England");
		countryList.put("GER", "Germany");
		countryList.put("BR", "Brazil");
		countryList.put("FR", "France");
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public LinkedHashMap<String, String> getCountryList() {
		return countryList;
	}

	public void setCountryList(LinkedHashMap<String, String> countryList) {
		this.countryList = countryList;
	}

	public List<String> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(List<String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
}
