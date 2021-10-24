package com.example.springmvcdemo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.springmvcdemo.validation.CourseCode;

public class Student {

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String firstName;
	private String lastName;
	private String country;
	private Map<String, String> countryOptions;
	private String favoriteLanguage;
	private Map<String, String> favoriteLanguageOptions;
	private String[] operatingSystems;
	
	@Min(value=0, message="value must be greater than or equal to 0")
	@Max(value=10, message="value must be less than or equal to 10")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 digits")
	private String postalCode;
	
	@CourseCode
	private String courseCode;
	
	public Student() {
		this.countryOptions = new LinkedHashMap<String, String>();
		this.countryOptions.put("IN", "India");
		this.countryOptions.put("BR", "Brazil");
		this.countryOptions.put("DE", "Germany");
		this.countryOptions.put("FR", "France");
		this.countryOptions.put("US", "United States Of America");
		
		this.favoriteLanguageOptions = new LinkedHashMap<String, String>();
		this.favoriteLanguageOptions.put("Python", "Python");
		this.favoriteLanguageOptions.put("R", "R");
		this.favoriteLanguageOptions.put("CPP", "C++");
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

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public Map<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", favoriteLanguage=" + favoriteLanguage + ", operatingSystems=" + Arrays.toString(operatingSystems)
				+ ", freePasses=" + freePasses + ", postalCode=" + postalCode + ", courseCode=" + courseCode + "]";
	}
}
