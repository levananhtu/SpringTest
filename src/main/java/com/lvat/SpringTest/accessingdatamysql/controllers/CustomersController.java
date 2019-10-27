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

<<<<<<< HEAD
    @RequestMapping(path = "/by-customer-number", method = RequestMethod.GET)
    public List<Customers> getCustomersById(@RequestParam(value = "id", defaultValue = "145") Long customerNumber, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customersRepository.findByCustomerNumber(customerNumber, Customers.class, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Customers> getAllCustomers(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        return customersRepository.findAll(PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    @RequestMapping(path = "/by-customer-name", method = RequestMethod.GET)
    public List<Customers> getCustomersByCustomerName(@RequestParam(value = "customer-name", defaultValue = "") String customerName, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customersRepository.findByCustomerNameContaining(customerName, Customers.class, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    @RequestMapping(path = "/by-country-and-state", method = RequestMethod.GET)
    public List<Customers> getCustomersByCountryAndState(@RequestParam(value = "country", defaultValue = "") String country, @RequestParam(value = "state", defaultValue = "") String state, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customersRepository.findByCountryAndState(country, state, Customers.class, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    @RequestMapping(path = "/orders", method = RequestMethod.GET)
    public List<List<Orders>> getOrdersById(@RequestParam(value = "id", defaultValue = "145") Long customerNumber, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        List<List<Orders>> ordersList = new LinkedList<>();
        List<Customers> customersList = customersRepository.findByCustomerNumber(customerNumber, Customers.class, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
        for (Customers customer : customersList) {
            ordersList.add(customer.getOrdersList());
=======
    @RequestMapping(path = "/customer-number", method = RequestMethod.GET)
    public Object getCustomersById(@RequestParam(value = "id", defaultValue = "145") Long customerNumber) {
        try {
//            return customersRepository.getCustomerNameByCustomerNumber(customerNumber, CustomersProjection01.class).get(0);
            return customersRepository.getCustomerNameByCustomerNumber(customerNumber, Customers.class);
        } catch (IndexOutOfBoundsException e) {
            return null;
>>>>>>> parent of 8d5ac2c... checkpoint03
        }
//        return customersArrayList.get(1).getCustomerName();
//        return ((Collection<Customers>) this.customersRepository.findAll()).;
    }

<<<<<<< HEAD
    @RequestMapping(path = "/cn-cl", method = RequestMethod.GET)
    public List<Customers> getByCustomerNameAndCreditLimit(@RequestParam(value = "customer-name", defaultValue = "") String customerName,
                                                           @RequestParam(value = "credit-limit", defaultValue = "100000") Double creditLimit,
                                                           @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customersRepository.findByCustomerNameContainingAndCreditLimitLessThanEqual(customerName, creditLimit, Customers.class, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
=======
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public Object getAllCustomers() {
        return customersRepository.findAll();
>>>>>>> parent of 8d5ac2c... checkpoint03
    }
}