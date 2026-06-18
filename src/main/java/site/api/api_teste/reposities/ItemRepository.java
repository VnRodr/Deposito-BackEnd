package site.api.api_teste.reposities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.api.api_teste.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
  @Query("SELECT i FROM items i WHERE i.item_name = :itemName")
  User findItemByName(@Param('itemName') String name);
}
