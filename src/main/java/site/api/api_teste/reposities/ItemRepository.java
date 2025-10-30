package site.api.api_teste.reposities;

import org.springframework.data.jpa.repository.JpaRepository;

import site.api.api_teste.entities.Item;

public interface ItemRepository extends JpaRepository<Item, String> {
}
