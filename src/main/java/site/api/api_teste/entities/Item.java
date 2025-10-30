package site.api.api_teste.entities;

import java.math.BigDecimal;
import java.util.Objects;

import  org.hibernate.proxy.HibernateProxy;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import site.api.api_teste.enums.itemType;

@Data
public class Item
{
    @Id
    private String id;

    @Column(nullable = false, length = 80, name = "item_name")
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "item_type")
    private itemType itemType;

    @Column(nullable = false, scale = 5, precision = 2)
    private BigDecimal price;

    @Column(name = "qty", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_owner")
    private User itemOwner;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Item item = (Item) o;
        return getId() != null && Objects.equals(getId(), item.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
