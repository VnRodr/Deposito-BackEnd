package site.api.api_teste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import site.api.api_teste.entities.StockGroup;

public class StockGroupService {

    @Autowired
    private StockGroupService stockGroupRepository;

    public List<StockGroup> findAll() {
        List<StockGroup> StockGroupEntityList = stockGroupRepository.findAll();

        return new ArrayList<>(StockGroupEntityList);
    }

    public StockGroup findById(String id) {
        return stockGroupRepository.findById(id);
    }

    public void saveEntity(StockGroup entity) {
        stockGroupRepository.saveEntity(entity);
        ;
    }

    public void changeEntity(StockGroup newEntity) {
        stockGroupRepository.saveEntity(newEntity);
    }

    public void deleteEntity(String id) {
        stockGroupRepository.deleteEntity(id);
    }
}
