package entity;

import java.math.BigDecimal;

public class EmployeeEntity {
    private String lastName;
    private String firstName;
    private String email;
    private String department;
    private BigDecimal salary;

    public EmployeeEntity(String last_name, String first_name, String email, String department, BigDecimal salary) {
        this.lastName = last_name;
        this.firstName = first_name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    public EmployeeEntity(String last_name, String first_name, BigDecimal salary) {
        this.lastName = last_name;
        this.firstName = first_name;
        this.salary = salary;
    }

    public EmployeeEntity(String last_name, String first_name) {
        this.lastName = last_name;
        this.firstName = first_name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
