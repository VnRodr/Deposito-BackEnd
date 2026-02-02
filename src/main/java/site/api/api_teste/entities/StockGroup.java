package site.api.api_teste.entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import site.api.api_teste.enums.StockStatus;

@Entity
@Table(name = "stock_groups")
public class StockGroup {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;

    @Column(nullable = false, length = 80, name = "stockgroup_name")
    private String name;

    @Column(nullable = false, name = "stockgroup_total_items")
    private Integer totalItems;

    @Column(nullable = false, name = "stockgroup_value")
    private Double value;

    @Column(nullable = false, name = "stockgroup_low_stock")
    private Integer lowStock;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "stockgroup_status")
    private StockStatus status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee responsible;

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
