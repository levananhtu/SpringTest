package com.lvat.SpringTest.accessingdatamysql.repositories;

import com.lvat.SpringTest.accessingdatamysql.entities.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customers, Integer> {
    <T> List<T> getCustomerNameByCustomerNumber(Long customerNumber, Class<T> type);
}
