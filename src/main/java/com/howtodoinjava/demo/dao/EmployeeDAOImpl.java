package com.howtodoinjava.demo.dao;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.howtodoinjava.demo.model.EmployeeVO;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    List<EmployeeVO> employees = new ArrayList<EmployeeVO>();

    EmployeeDAOImpl(){
        EmployeeVO one=new EmployeeVO();
        one.setId(1);
        one.setFirstName("naveen");
        one.setLastName("sundar");
        one.setEmail("naveen@gmail.com");
        employees.add(one);


        EmployeeVO two=new EmployeeVO();
        two.setId(1);
        two.setFirstName("sangeeth");
        two.setLastName("soundar");
        two.setEmail("soundar@gmail.com");
        employees.add(two);
    }

    @Override
    public List<EmployeeVO> getAllEmployees() {
        return employees;
    }

    public void addEmployee(String firstname, String lastname, Integer id, String email) {
        EmployeeVO emp=new EmployeeVO();
        emp.setId(id);
        emp.setFirstName(firstname);
        emp.setLastName(lastname);
        emp.setEmail(email);
        employees.add(emp);
    }
}