package site.api.api_teste.dtos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import site.api.api_teste.entities.Employee;
import site.api.api_teste.enums.StockStatus;

@Entity
public class StockGroupDTO implements Serializable{
    static final long serialVersionUID = 0421415334L;

    private String id;
    private String name;
    private Integer totalItems;
    private Double value;
    private Integer lowStock;
    private StockStatus status;
    private Employee responsible;

    public StockGroupDTO(String id, String name, Integer totalItems, Double value, Integer lowStock, StockStatus status,
            Employee responsible) {
        this.id = id;
        this.name = name;
        this.totalItems = totalItems;
        this.value = value;
        this.lowStock = lowStock;
        this.status = status;
        this.responsible = responsible;
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

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public StockStatus getStatus() {
        return status;
    }

    public void setStatus(StockStatus status) {
        this.status = status;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public void setResponsible(Employee responsible) {
        this.responsible = responsible;
    }

}
