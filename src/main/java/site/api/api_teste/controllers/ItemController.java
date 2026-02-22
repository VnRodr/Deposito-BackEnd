package site.api.api_teste.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.api.api_teste.dtos.ItemDTO;
import site.api.api_teste.enums.HttpsStatusCodes;
import site.api.api_teste.services.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> showAllItems() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDTO> findById(@PathVariable String id) {
        ItemDTO item = itemService.findById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping("/create-item")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO item) {
        ItemDTO savedItem = itemService.saveEntity(item);
        URI location = URI.create("/api/create-item" + savedItem.getId());
        return ResponseEntity.created(location).body(savedItem);
    }

    @PutMapping("/update-item")
    public ResponseEntity<HttpsStatusCodes> updateEntity(@RequestBody ItemDTO item) {
        itemService.changeEntity(item);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/items/{id}")
    public ResponseEntity<HttpsStatusCodes> deleteEntity(@PathVariable String id) {
        itemService.deleteEntity(id);
        return ResponseEntity.ok().build();
    }
}
