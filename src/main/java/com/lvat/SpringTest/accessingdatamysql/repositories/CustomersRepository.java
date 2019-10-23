package com.lvat.SpringTest.accessingdatamysql.repositories;

import com.lvat.SpringTest.accessingdatamysql.entities.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CustomersRepository extends PagingAndSortingRepository<Customers, Integer> {
    <T> Page<T> findByCustomerNumber(Long customerNumber, Class<T> type, Pageable pageable);

    <T> Page<T> findByCustomerNameContaining(String customerName, Class<T> type, Pageable pageable);

    <T> Page<T> findByCountryAndState(String country, String state, Class<T> type, Pageable pageable);

    <T> Page<T> findByCustomerNameContainingAndCreditLimitLessThanEqual(String customerName, Double creditLimit, Class<T> type, Pageable pageable);

}
