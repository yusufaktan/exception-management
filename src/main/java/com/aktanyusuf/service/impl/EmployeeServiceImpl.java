package com.aktanyusuf.service.impl;

import com.aktanyusuf.dto.DtoDepartment;
import com.aktanyusuf.dto.DtoEmployee;
import com.aktanyusuf.exception.BaseException;
import com.aktanyusuf.exception.ErrorMessage;
import com.aktanyusuf.exception.MessageType;
import com.aktanyusuf.model.Department;
import com.aktanyusuf.model.Employee;
import com.aktanyusuf.repository.EmployeeRepository;
import com.aktanyusuf.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee findEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.RESOURCE_NOT_FOUND, id.toString()));
        }

        Employee employee = optional.get();
        Department department = employee.getDepartment();
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);
        dtoEmployee.setDepartment(dtoDepartment);

        return dtoEmployee;
    }
}
