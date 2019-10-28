package com.lvat.SpringTest.accessingdatamysql.controllers;

import com.lvat.SpringTest.accessingdatamysql.entities.projections.employes.EmployeesFullProjection;
import com.lvat.SpringTest.accessingdatamysql.entities.projections.employes.EmployeesProjection;
import com.lvat.SpringTest.accessingdatamysql.entities.projections.employes.EmployeesProjection01;
import com.lvat.SpringTest.accessingdatamysql.services.EmployeesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeesController {
    private final static int SIZE = 20;
    private final EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @RequestMapping(path = "/by-employee-number", method = RequestMethod.GET)
    public EmployeesProjection getCustomersById(@RequestParam(value = "employee-number", defaultValue = "1002") Long employeeNumber, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return employeesService.findByEmployeeNumber(employeeNumber, EmployeesProjection01.class);
    }

    @RequestMapping(path = "/fn_ln", method = RequestMethod.GET)
    public List<EmployeesFullProjection> getByFirstNameContainingAndLastNameContaining(@RequestParam(value = "first-name", defaultValue = "ma") String firstName,
                                                                                       @RequestParam(value = "last-name", defaultValue = "pat") String lastName,
                                                                                       @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return employeesService.findByFirstNameContainingOrLastNameContaining(firstName, lastName, EmployeesFullProjection.class, page);
    }
}
