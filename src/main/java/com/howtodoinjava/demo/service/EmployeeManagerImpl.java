package com.howtodoinjava.demo.service;

import java.util.List;

import com.howtodoinjava.demo.dao.EmployeeDAO;
import com.howtodoinjava.demo.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManagerImpl implements EmployeeManager{
    @Autowired
    EmployeeDAO dao;

    @Override
    public List<EmployeeVO> getAllEmployees() {
        return dao.getAllEmployees();
    }
}