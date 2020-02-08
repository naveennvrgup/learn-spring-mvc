package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.EmployeeVO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return EmployeeVO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName", "firstname required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName", "lastname required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id", "id required");
    }
}
