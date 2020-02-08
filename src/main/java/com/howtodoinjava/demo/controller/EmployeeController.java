package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.EmployeeVO;
import com.howtodoinjava.demo.service.EmployeeManager;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmployeeManager manager;

    @Autowired
    Validator validator;

    @RequestMapping(value = "/")
    public String hellWorld(@RequestParam("id") String id, Model model) {
        model.addAttribute("message", "spring mvc 3 hello world");
        model.addAttribute("id", id);
        return "helloworld";
    }


    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public String getAllEmployees(Model model, @RequestParam("haserr")boolean haserr) {

        model.addAttribute("employees", manager.getAllEmployees());
        model.addAttribute("haserr", haserr);

        return "employeesListDisplay";
    }

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("employee") EmployeeVO employeeVO,
                             BindingResult result, SessionStatus status, RedirectAttributes redirectAttributes) {

        Set<ConstraintViolation<EmployeeVO>> violations = validator.validate(employeeVO);

        for (ConstraintViolation<EmployeeVO> violation : violations)
        {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("employee",propertyPath,

                    "Invalid "+ propertyPath + "(" + message + ")"));
        }


        redirectAttributes.addAttribute("haserr",false);

        manager.addEmployee(employeeVO.getFirstName(),
                employeeVO.getLastName(),
                employeeVO.getId(),
                employeeVO.getEmail());

        status.setComplete();

        return "redirect:/getAllEmployees";
    }
}