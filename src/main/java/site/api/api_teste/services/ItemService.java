package site.api.api_teste.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.Data;
import site.api.api_teste.entities.Item;
import site.api.api_teste.reposities.ItemRepository;

@Data
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        List<Item> itemEntityList = itemRepository.findAll();

        return new ArrayList<>(itemEntityList);
    }

    public Item findById(String id)
    {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
    }

    public void saveEntity(Item entity)
    {
        itemRepository.save(entity);
    }

    public void changeEntity (Item newEntity)
    {
        itemRepository.save(newEntity);
    }

    public void deleteEntity (String id)
    {
        itemRepository.deleteById(id);
    }
}
