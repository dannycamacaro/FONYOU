package com.fonyou.test.employee.controller;

import com.fonyou.test.employee.entity.EmployeeEntity;
import com.fonyou.test.employee.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @PostMapping
    @ResponseBody
    public List<EmployeeEntity> insertEmployee(@Valid @RequestBody EmployeeEntity employeeEntity, HttpServletResponse response) {
        employeeServices.create(employeeEntity);
        response.setStatus(201);
        return employeeServices.getAll();
    }

    @DeleteMapping
    @ResponseBody
    public List<EmployeeEntity> deleteEmployeeById(@RequestBody EmployeeEntity employee, HttpServletResponse response) {
        if (employee.getId() != null) {
            EmployeeEntity employeeEntity = employeeServices.getById(employee.getId());
            if (employeeEntity != null) {
                employeeServices.delete(employeeEntity);
                response.setStatus(HttpStatus.ACCEPTED.value());
            } else {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
            }
        } else {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return employeeServices.getAll();
    }

    @PutMapping
    public List<EmployeeEntity> updateEmployee(@Valid @RequestBody EmployeeEntity employeeEntity, HttpServletResponse response) {
        if (employeeEntity.getId() != null && employeeEntity.getId() > 0 && employeeServices.getById(employeeEntity.getId()) != null) {
            employeeServices.update(employeeEntity);
            response.setStatus(HttpStatus.ACCEPTED.value());
        } else {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return employeeServices.getAll();
    }

    @GetMapping
    public EmployeeEntity getEmployeeById(@RequestBody(required = false) EmployeeEntity employeeEntity,
                                              HttpServletResponse response, @RequestParam(required = false, defaultValue = "0") String id) {
        response.setStatus(HttpStatus.OK.value());
        if (!id.equalsIgnoreCase("0") ) {
            response.setStatus(HttpStatus.ACCEPTED.value());
            return employeeServices.getById(Integer.parseInt(id));
        } else {
            response.setStatus(HttpStatus.ACCEPTED.value());
            return employeeServices.getById(employeeEntity.getId());
        }
    }

    @RequestMapping("allemployees")
    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeServices.getAll();
    }

}
