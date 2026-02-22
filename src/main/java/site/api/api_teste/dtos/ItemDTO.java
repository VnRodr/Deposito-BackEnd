package site.api.api_teste.dtos;

import java.io.Serializable;

public class ItemDTO implements Serializable {
    static final long serialVersionUID = 842113451L;

    private String id;
    private String SKU;
    private String name;
    private String category;
    private Integer quantity;
    private Boolean unitValue;
    private Integer lowQuantity;

    public ItemDTO() {
    }

    public ItemDTO(String id, String sKU, String name, String category, Integer quantity, Boolean unitValue,
            Integer lowQuantity) {
        this.id = id;
        this.SKU = sKU;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unitValue = unitValue;
        this.lowQuantity = lowQuantity;
    }

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
