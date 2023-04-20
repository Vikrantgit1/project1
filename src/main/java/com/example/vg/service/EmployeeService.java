package com.example.vg.service;

import com.example.vg.model.Employees;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employees> getAllEmployees();
    void saveEmployee(Employees employee);
    Employees getEmployeeById(Integer id);
    void deleteEmployeeById(Integer id);
    Page<Employees> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
