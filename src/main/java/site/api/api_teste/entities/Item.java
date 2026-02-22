package site.api.api_teste.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "items")
public class Item {

  @Id
  @GeneratedValue
  @UuidGenerator(style = UuidGenerator.Style.TIME)
  private String id;

  @Column(nullable = false, length = 50, name = "item_sku")
  private String SKU;

  @Column(nullable = false, length = 80, name = "item_name")
  private String name;

  @Column(nullable = false, length = 80, name = "item_category")
  private String category;

  @Column(nullable = false, name = "item_quantity")
  private Integer quantity;

  @Column(nullable = false, name = "item_unit_value")
  private Boolean unitValue;

  @Column(nullable = false, name = "item_low_quantity")
  private Integer lowQuantity;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSKU() {
    return SKU;
  }

  public void setSKU(String sKU) {
    SKU = sKU;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Boolean getUnitValue() {
    return unitValue;
  }

  public void setUnitValue(Boolean unitValue) {
    this.unitValue = unitValue;
  }

  public Integer getLowQuantity() {
    return lowQuantity;
  }

  public void setLowQuantity(Integer lowQuantity) {
    this.lowQuantity = lowQuantity;
  }
}
