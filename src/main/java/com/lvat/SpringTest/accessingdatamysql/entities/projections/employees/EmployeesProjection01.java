package com.lvat.SpringTest.accessingdatamysql.entities.projections.employees;

public class EmployeesProjection01 extends EmployeesProjection {
    private String lastName;

    private String firstName;

    public EmployeesProjection01() {
    }

    public EmployeesProjection01(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
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
}
