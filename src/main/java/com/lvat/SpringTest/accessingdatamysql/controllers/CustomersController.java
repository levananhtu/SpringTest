package com.lvat.SpringTest.accessingdatamysql.controllers;

import com.lvat.SpringTest.accessingdatamysql.entities.Customers;
import com.lvat.SpringTest.accessingdatamysql.entities.Orders;
import com.lvat.SpringTest.accessingdatamysql.entities.projections.customers.CustomersProjection;
import com.lvat.SpringTest.accessingdatamysql.entities.projections.customers.CustomersProjection01;
import com.lvat.SpringTest.accessingdatamysql.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomersController {
    private final CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @RequestMapping(path = "/by-customer-number", method = RequestMethod.GET)
    public CustomersProjection getCustomersByCustomerNumber(@RequestParam(value = "customer-number", defaultValue = "145") Long customerNumber) {
        return customersService.getCustomersByCustomerNumber(customerNumber, CustomersProjection01.class);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Customers> getAllCustomers(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customersService.getAllCustomers(page, Customers.class);
    }

    @RequestMapping(path = "/by-customer-name", method = RequestMethod.GET)
    public List<Customers> getCustomersByCustomerName(@RequestParam(value = "customer-name", defaultValue = "") String customerName, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customersService.getCustomersByCustomerName(customerName, Customers.class, page);
    }

    @RequestMapping(path = "/by-country-and-state", method = RequestMethod.GET)
    public List<Customers> getCustomersByCountryAndState(@RequestParam(value = "country", defaultValue = "") String country, @RequestParam(value = "state", defaultValue = "") String state, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customersService.getCustomersByCountryAndState(country, state, Customers.class, page);
    }

    @RequestMapping(path = "/orders", method = RequestMethod.GET)
    public List<List<Orders>> getOrdersByCustomerNumber(@RequestParam(value = "customer-number", defaultValue = "145") Long customerNumber) {
        return customersService.getOrdersByCustomerNumber(customerNumber);
    }

    @RequestMapping(path = "/cn-cl", method = RequestMethod.GET)
    public List<Customers> getByCustomerNameAndCreditLimit(@RequestParam(value = "customer-name", defaultValue = "") String customerName,
                                                           @RequestParam(value = "credit-limit", defaultValue = "100000") Double creditLimit,
                                                           @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customersService.getByCustomerNameAndCreditLimit(customerName, creditLimit, Customers.class, page);
    }
}