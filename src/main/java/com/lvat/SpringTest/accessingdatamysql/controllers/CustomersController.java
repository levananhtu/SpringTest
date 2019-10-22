package com.lvat.SpringTest.accessingdatamysql.controllers;

import com.lvat.SpringTest.accessingdatamysql.entities.Customers;
import com.lvat.SpringTest.accessingdatamysql.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customers")
public class CustomersController {
    @Autowired
    private CustomersRepository customersRepository;

    @RequestMapping(path = "/customer-number", method = RequestMethod.GET)
    public Object getCustomersById(@RequestParam(value = "id", defaultValue = "145") Long customerNumber) {
        try {
//            return customersRepository.getCustomerNameByCustomerNumber(customerNumber, CustomersProjection01.class).get(0);
            return customersRepository.getCustomerNameByCustomerNumber(customerNumber, Customers.class);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
//        return customersArrayList.get(1).getCustomerName();
//        return ((Collection<Customers>) this.customersRepository.findAll()).;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public Object getAllCustomers() {
        return customersRepository.findAll();
    }
}