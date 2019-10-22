package com.lvat.SpringTest.accessingdatamysql;

import com.lvat.SpringTest.accessingdatamysql.entities.Customers;
import com.lvat.SpringTest.accessingdatamysql.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "/hoho")
public class MainController {
    @Autowired
    private CustomersRepository customersRepository;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllCustomers(@RequestParam(value = "id", defaultValue = "145") Long customerNumber) {
//        ArrayList<Customers> customersArrayList = new ArrayList<>((Collection<Customers>) this.customersRepository.findAll());
//        return customersArrayList.get(1).getCustomerName();
//        return ((Collection<Customers>) this.customersRepository.findAll()).;
        return null;
    }
}
