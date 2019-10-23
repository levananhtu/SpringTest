package com.lvat.SpringTest.accessingdatamysql.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "employees",
        indexes = {@Index(name = "office_code", columnList = "office_code"), @Index(name = "reports_to", columnList = "reports_to")})
@Entity(name = "Employees")
public class Employees implements Serializable {
    @Id
    @Column(name = "employee_number", nullable = false)
    private Long employeeNumber;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "extension", nullable = false)
    private String extension;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "office_code", nullable = false)
    private String officeCode;

    @Column(name = "reports_to")
    private Long reportsTo;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employee_number", name = "reports_to", insertable = false, updatable = false)
    @JsonBackReference
    private Employees employee;

    @ManyToOne
    @JoinColumn(referencedColumnName = "office_code", name = "office_code", insertable = false, updatable = false)
    @JsonBackReference
    private Offices office;

    @OneToMany(targetEntity = Customers.class)
    @JoinColumn(referencedColumnName = "employee_number", name = "sales_rep_employee_number")
    @JsonManagedReference
    @JsonIgnore
    private List<Customers> customersList;

    @OneToMany(targetEntity = Employees.class)
    @JoinColumn(referencedColumnName = "reports_to", name = "employee_number")
    @JsonManagedReference
    @JsonIgnore
    private List<Employees> employeesList;

    public Employees() {
    }

    public Employees(Long employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, Long reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Long getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Long reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

//    @JsonIgnore
    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

//    @JsonIgnore
    public Offices getOffice() {
        return office;
    }

    public void setOffice(Offices office) {
        this.office = office;
    }

//    @JsonIgnore
    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }

//    @JsonIgnore
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }
}
