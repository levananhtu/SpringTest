package com.lvat.SpringTest.accessingdatamysql.entities.projections.customers;

public interface CustomersFullProjection extends CustomersProjection {
    Long getCustomerNumber();

    String getCustomerName();

    String getContactFirstName();

    String getContactLastName();

    String getPhone();

    String getAddressLine1();

    String getAddressLine2();

    String getCity();

    String getState();

    String getPostalCode();

    String getCountry();

    Long getSalesRepEmployeeNumber();

    Double getCreditLimit();

}
