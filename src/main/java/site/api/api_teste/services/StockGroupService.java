package site.api.api_teste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import site.api.api_teste.entities.StockGroup;
import site.api.api_teste.enums.HttpsStatusCodes;
import site.api.api_teste.reposities.StockGroupRepository;

@Service
public class StockGroupService {

    @Autowired
    private StockGroupRepository stockGroupRepository;

    public List<StockGroup> findAll() {
        List<StockGroup> StockGroupEntityList = stockGroupRepository.findAll();

        return new ArrayList<>(StockGroupEntityList);
    }

    public StockGroup findById(String id) {
        return stockGroupRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpsStatusCodes.NotFoundStatus(),
                                "Stock group not found"));
    }

    public void saveEntity(StockGroup entity) {
        stockGroupRepository.save(entity);
    }

    public void changeEntity(StockGroup newEntity) {
        stockGroupRepository.save(newEntity);
    }

    public void deleteEntity(String id) {
        stockGroupRepository.deleteById(id);
    }
}
