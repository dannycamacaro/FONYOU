package com.fonyou.test.employee.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAMES")
    @NotNull(message = "Por favor inserte los nombres")
    @NotBlank(message = "Por favor inserte los nombres")
    private String employeeNames;

    @Column(name = "LAST_NAMES")
    @NotNull(message = "Por favor inserte los apellidos")
    @NotBlank(message = "Por favor inserte los apellidos")
    private String employeeLastNames;

    @Column(name = "BIRTHDATE")
    @NotNull(message = "Por favor inserte la fecha de cumpleaños")
    @Past(message = "Ingrese una fecha valida de fecha de nacimiento")
    private LocalDate birthday;

    @Column(name = "SALARY")
    @NotNull(message = "Por favor inserte el salario")
    private BigDecimal salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(String employeeNames) {
        this.employeeNames = employeeNames;
    }

    public String getEmployeeLastNames() {
        return employeeLastNames;
    }

    public void setEmployeeLastNames(String employeeLasNames) {
        this.employeeLastNames = employeeLasNames;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
