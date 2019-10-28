package com.lvat.SpringTest.accessingdatamysql.services;

import com.lvat.SpringTest.accessingdatamysql.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesService {
    private final static int SIZE = 20;
    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public <T> List<T> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Class<T> type, Integer page) {
        return employeesRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(firstName, lastName, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public <T> List<T> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName, Class<T> type, Integer page) {
        return employeesRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public <T> T findByEmployeeNumber(Long employeeNumber, Class<T> type) {
        return employeesRepository.findByEmployeeNumber(employeeNumber, type);
    }
}
