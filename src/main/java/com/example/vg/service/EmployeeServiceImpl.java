package com.example.vg.service;

import com.example.vg.model.Employees;
import com.example.vg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employees> getAllEmployees() {
        try{
            employeeRepository.findAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveEmployee(Employees employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employees getEmployeeById(Integer id) {
        Optional<Employees> optional = employeeRepository.findById(id);
        Employees employees = null;
        if(optional.isPresent())
            employees = optional.get();
        else
            throw new RuntimeException("Employee not found for id :: "+id);
        return employees;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employees> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);    }
}
