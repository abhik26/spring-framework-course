package com.example.springmvcdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	String coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		this.coursePrefix = courseCode.value();
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext arg1) {
		boolean valid = true;
		
		if (code != null && !code.isEmpty()) {
			valid = code.startsWith(coursePrefix);
		}
		
		return valid;
	}

}
