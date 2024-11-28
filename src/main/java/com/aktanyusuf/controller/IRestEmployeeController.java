package com.aktanyusuf.controller;

import com.aktanyusuf.dto.DtoEmployee;

public interface IRestEmployeeController {

    public DtoEmployee findEmployeeById(Long id);

}
