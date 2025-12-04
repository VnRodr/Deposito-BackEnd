package site.api.api_teste.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import site.api.api_teste.entities.StockGroup;
import site.api.api_teste.services.StockGroupService;

@RestController
public class StockGroupController {
    @Autowired
    private StockGroupService stockGroupService;

    @GetMapping("/stockGroups")
    public ResponseEntity<List<StockGroup>> showAllStockGroups() {
        return ResponseEntity.ok(stockGroupService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockGroup> findById(@PathVariable String id) {
        StockGroup stockGroup = stockGroupService.findById(id);
        return ResponseEntity.ok(stockGroup);
    }

    @PostMapping("/create-stockGroup")
    public ResponseEntity<StockGroup> createStockGroup(@RequestBody StockGroup stockGroup) {
        stockGroupService.saveEntity(stockGroup);
        URI location = URI.create("/api/create-stockGroup" + stockGroup.getId());
        return ResponseEntity.created(location).body(stockGroup);
    }

    @PutMapping("/update-stockGroup")
    public ResponseEntity<HttpStatus> atualizarEntidade(@RequestBody StockGroup stockGroup) {
        stockGroupService.changeEntity(stockGroup);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletarEntidade(@PathVariable String id) {
        stockGroupService.deleteEntity(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
