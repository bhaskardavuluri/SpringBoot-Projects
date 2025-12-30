package com.example.Department_Details.service;

import com.example.Department_Details.dto.DepartmentDto;
import com.example.Department_Details.entity.Department;

public interface DepartmentService {
    DepartmentDto createEmployees(DepartmentDto departmentDto);
    DepartmentDto getEmployees(Long id);
  //  DepartmentDto updateEmployee(Long id,DepartmentDto departmentDto);
}
