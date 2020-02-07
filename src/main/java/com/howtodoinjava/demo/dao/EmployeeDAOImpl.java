package com.howtodoinjava.demo.dao;
import java.util.ArrayList;
import java.util.List;

import com.howtodoinjava.demo.model.EmployeeVO;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<EmployeeVO> getAllEmployees() {
        List<EmployeeVO> employees = new ArrayList<EmployeeVO>();

        EmployeeVO one=new EmployeeVO();
        one.setId(1);
        one.setFirstName("naveen");
        one.setLastName("sundar");
        employees.add(one);


        EmployeeVO two=new EmployeeVO();
        two.setId(1);
        two.setFirstName("sangeeth");
        two.setLastName("soundar");
        employees.add(two);

        return employees;
    }
}