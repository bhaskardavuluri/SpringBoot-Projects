package com.example.Department_Details.controller;

import com.example.Department_Details.dto.DepartmentDto;
import com.example.Department_Details.entity.Department;
import com.example.Department_Details.service.Impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl service;
    @PostMapping("/saveDepartment")
    public ResponseEntity<DepartmentDto> createEmployees(@RequestBody DepartmentDto departmentDto){
        DepartmentDto D=service.createEmployees(departmentDto);
        return new ResponseEntity<>(D, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto>findEmployee(@PathVariable Long id){
        DepartmentDto  D=service.getEmployees(id);
        return new ResponseEntity<>(D,HttpStatus.OK);

    }
}
