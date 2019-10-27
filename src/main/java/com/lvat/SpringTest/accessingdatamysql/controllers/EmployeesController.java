package com.lvat.SpringTest.accessingdatamysql.controllers;

import com.lvat.SpringTest.accessingdatamysql.entities.projections.employees.EmployeesFullProjection;
import com.lvat.SpringTest.accessingdatamysql.entities.projections.employees.EmployeesProjection;
import com.lvat.SpringTest.accessingdatamysql.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(path = "/employees")
public class EmployeesController {

    private final EmployeesRepository employeesRepository;

    public EmployeesController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @RequestMapping(path = "employee-number", method = RequestMethod.GET)
    public List<EmployeesProjection> findByEmployeeNumber(@RequestParam(value = "employee-number", defaultValue = "1002") Long employeeNumber, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return employeesRepository.findByEmployeeNumber(employeeNumber, EmployeesFullProjection.class, PageRequest.of(page, 20)).get().collect(Collectors.toList());
    }
}
