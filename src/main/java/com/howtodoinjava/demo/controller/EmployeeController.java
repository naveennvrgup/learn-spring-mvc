package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.EmployeeVO;
import com.howtodoinjava.demo.service.EmployeeManager;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmployeeManager manager;

    @Autowired
    EmployeeValidator employeeValidator;

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
    public String addEmployee(@ModelAttribute("employee") EmployeeVO employeeVO, RedirectAttributes redirectAttributes,
                              BindingResult bindingResult, SessionStatus sessionStatus, Model model) {

        employeeValidator.validate(employeeVO, bindingResult);

        if (!bindingResult.hasErrors()){
            manager.addEmployee(employeeVO.getFirstName(), employeeVO.getLastName(), employeeVO.getId());
            System.out.println("added employee");
        }

        redirectAttributes.addAttribute("haserr", bindingResult.hasErrors());
        return "redirect:/getAllEmployees";
    }
}