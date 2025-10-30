package site.api.api_teste.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.proxy.HibernateProxy;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Data
public class User {

    @Id
    private String id; //Cria um id em String único

    @Column (nullable = false, length = 30, name = "first_name")
    private String firstName;

    @Column (nullable = false, length = 100, name = "last_name")
    private String lastName;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false, name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "itemOwner", fetch = FetchType.LAZY)
    @ToString.Exclude
    List<Item> itemsList = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
