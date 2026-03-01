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
import site.api.api_teste.dtos.StockGroupDTO;
import site.api.api_teste.enums.HttpsStatusCodes;
import site.api.api_teste.services.StockGroupService;

@RestController
@RequestMapping("/api")
public class StockGroupController {
  @Autowired private StockGroupService stockGroupService;

  @GetMapping("/stockGroups")
  public ResponseEntity<List<StockGroupDTO>> showAllStockGroups() {
    return ResponseEntity.ok(stockGroupService.findAll());
  }

  @GetMapping("/stockGroups/{id}")
  public ResponseEntity<StockGroupDTO> findById(@PathVariable String id) {
    StockGroupDTO stockGroup = stockGroupService.findById(id);
    return ResponseEntity.ok(stockGroup);
  }

  @PostMapping("/create-stockGroup")
  public ResponseEntity<StockGroupDTO> createStockGroup(@RequestBody StockGroupDTO stockGroup) {
    StockGroupDTO savedStockGroup = stockGroupService.saveEntity(stockGroup);
    URI location = URI.create("/api/create-stockGroup" + savedStockGroup.getId());
    return ResponseEntity.created(location).body(savedStockGroup);
  }

  @PutMapping("/update-stockGroup")
  public ResponseEntity<HttpsStatusCodes> atualizarEntidade(@RequestBody StockGroupDTO stockGroup) {
    stockGroupService.changeEntity(stockGroup);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/delete/stockGroups/{id}")
  public ResponseEntity<HttpsStatusCodes> deletarEntidade(@PathVariable String id) {
    stockGroupService.deleteEntity(id);
    return ResponseEntity.ok().build();
  }
}
