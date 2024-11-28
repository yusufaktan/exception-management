package com.aktanyusuf.service;

import com.aktanyusuf.dto.DtoEmployee;

public interface IEmployeeService {

    public DtoEmployee findEmployeeById(Long id);

}
