package site.api.api_teste.entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Employee {

    @UuidGenerator
    private String id;

    @Column(nullable = false, length = 80, name = "employee_name")
    private String name;

    @Column(nullable = false, length = 80, name = "employee_department")
    private String  department;

    @Column(nullable = false, length = 80, name = "employee_email")
    private String  email;

    @Column(nullable = false, length = 20, name = "employee_phone")
    private String  phone;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
