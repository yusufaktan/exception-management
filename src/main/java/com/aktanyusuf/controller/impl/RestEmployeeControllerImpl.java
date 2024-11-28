package com.aktanyusuf.controller.impl;

import com.aktanyusuf.controller.IRestEmployeeController;
import com.aktanyusuf.dto.DtoEmployee;
import com.aktanyusuf.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class RestEmployeeControllerImpl implements IRestEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(path = "/{id}")
    @Override
    public DtoEmployee findEmployeeById(@PathVariable(value = "id") Long id) {
        return employeeService.findEmployeeById(id);
    }
}
