package com.example.Department_Details.service.Impl;

import com.example.Department_Details.dto.DepartmentDto;
import com.example.Department_Details.entity.Department;
import com.example.Department_Details.repository.DepartmentRepository;
import com.example.Department_Details.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    @Override
    public DepartmentDto createEmployees(DepartmentDto departmentDto) {
        Department D=new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getSalary()
        );
        Department savedDepartment=repository.save(D);
        DepartmentDto saveDepartment=new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getName(),
                savedDepartment.getSalary()
        );
        return saveDepartment;
    }
    public DepartmentDto getEmployees(Long id){
   Department d=repository.findById(id)
           .orElseThrow(()->new RuntimeException("Employee not found with the id "));
   return new DepartmentDto(
           d.getId(),
           d.getName(),
           d.getSalary()
   );
    }

//    @Override
//    public DepartmentDto updateEmployee(Long id, DepartmentDto departmentDto) {
//        Department d=new Department(
//                d.setId(departmentDto.getId()),
//                d.setName(departmentDto.getName()),
//                d.setSalary(departmentDto.getSalary())
//        );
//
//    }
}
