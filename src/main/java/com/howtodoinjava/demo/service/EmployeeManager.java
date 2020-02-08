package com.howtodoinjava.demo.service;

import java.util.List;

import com.howtodoinjava.demo.model.EmployeeVO;

public  interface EmployeeManager{
    public List<EmployeeVO> getAllEmployees();
    public void addEmployee(String firstname, String lastname, Integer id, String email);
}