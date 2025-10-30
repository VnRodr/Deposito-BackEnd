package site.api.api_teste.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import site.api.api_teste.entities.Item;
import site.api.api_teste.services.ItemService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> showAllItems()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(itemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable String id)
    {
        Item item = itemService.findById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping("/create-item")
    public ResponseEntity<Item> createItem(@RequestBody Item item)
    {
        itemService.saveEntity(item);
        URI location = URI.create("/api/create-item" + item.getId());
        return ResponseEntity.created(location).body(item);
    }

    @PutMapping("/update-item")
    public void atualizarEntidade(@RequestBody Item item) {
        itemService.changeEntity(item);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarEntidade(@PathVariable String id) {
        itemService.deleteEntity(id);
    }
}
