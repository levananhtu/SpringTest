package com.lvat.SpringTest.accessingdatamysql.services;

import com.lvat.SpringTest.accessingdatamysql.entities.Customers;
import com.lvat.SpringTest.accessingdatamysql.entities.Orders;
import com.lvat.SpringTest.accessingdatamysql.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersService {
    private final static int SIZE = 20;
    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public <T> T getCustomersByCustomerNumber(Long customerNumber, Class<T> type) {
        return customersRepository.findByCustomerNumber(customerNumber, type);
    }

    public <T> List<T> getAllCustomers(Integer page, Class<T> type) {
        return customersRepository.findAllCustomersBy(type, PageRequest.of(0, 20)).get().collect(Collectors.toList());
    }

    public <T> List<T> getCustomersByCustomerName(String customerName, Class<T> type, Integer page) {
        return customersRepository.findByCustomerNameContaining(customerName, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public <T> List<T> getCustomersByCountryAndState(String country, String state, Class<T> type, Integer page) {
        return customersRepository.findByCountryAndState(country, state, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public List<List<Orders>> getOrdersByCustomerNumber(Long customerNumber) {
        List<List<Orders>> ordersList = new LinkedList<>();
        Customers customer = customersRepository.findByCustomerNumber(customerNumber, Customers.class);
        ordersList.add(customer.getOrdersList());
        return ordersList;
    }

    public <T> List<T> getByCustomerNameAndCreditLimit(String customerName, Double creditLimit, Class<T> type, Integer page) {
        return customersRepository.findByCustomerNameContainingAndCreditLimitLessThanEqual(customerName, creditLimit, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }
}
