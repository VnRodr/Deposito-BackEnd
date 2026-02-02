package site.api.api_teste.dtos;

import java.io.Serializable;
import java.util.List;

import site.api.api_teste.entities.StockGroup;

public class EmployeeDTO implements Serializable {
    static final long serialVersionUID = 213145123L;

    private String id;
    private String name;
    private String department;
    private String email;
    private String phone;
    private List<StockGroup> stockGroups;

    public EmployeeDTO(String id, String name, String department, String email, String phone,
            List<StockGroup> stockGroups) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.stockGroups = stockGroups;
    }

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

    public List<StockGroup> getStockGroups() {
        return stockGroups;
    }

    public void setStockGroups(List<StockGroup> stockGroups) {
        this.stockGroups = stockGroups;
    }

}
