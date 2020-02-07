package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class EmployeeController{
    @Autowired
    EmployeeManager manager;

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String hellWorld(Model model){
        return "helloworld";
    }


    @RequestMapping(value="/getAllEmployees",method= RequestMethod.GET)
    public String getAllEmployees(Model model){
        System.out.println(manager.getAllEmployees());
        model.addAttribute("employees",manager.getAllEmployees());
        return "employeesListDisplay";
    }
}