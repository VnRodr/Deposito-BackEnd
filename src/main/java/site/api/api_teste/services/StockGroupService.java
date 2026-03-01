package site.api.api_teste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import site.api.api_teste.dtos.StockGroupDTO;
import site.api.api_teste.entities.StockGroup;
import site.api.api_teste.enums.HttpsStatusCodes;
import site.api.api_teste.reposities.StockGroupRepository;

@Service
public class StockGroupService {

    @Autowired
    private StockGroupRepository stockGroupRepository;

    @Transactional
    public List<StockGroupDTO> findAll() {
        List<StockGroup> stockGroupEntityList = stockGroupRepository.findAll();
        List<StockGroupDTO> stockGroupDTOList = new ArrayList<>();

        for (StockGroup stockGroup : stockGroupEntityList) {
            stockGroupDTOList.add(toDTO(stockGroup));
        }

        return stockGroupDTOList;
    }

    @Transactional
    public StockGroupDTO findById(String id) {
        StockGroup stockGroup = stockGroupRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpsStatusCodes.NotFoundStatus(),
                                "Stock group not found"));

        return toDTO(stockGroup);
    }

    @Transactional
    public StockGroupDTO saveEntity(StockGroupDTO dto) {
        StockGroup entity = toEntity(dto);
        StockGroup savedEntity = stockGroupRepository.save(entity);
        return toDTO(savedEntity);
    }

    @Transactional
    public StockGroupDTO changeEntity(StockGroupDTO dto) {
        StockGroup entity = toEntity(dto);
        StockGroup savedEntity = stockGroupRepository.save(entity);
        return toDTO(savedEntity);
    }

    @Transactional
    public void deleteEntity(String id) {
        stockGroupRepository.deleteById(id);
    }

    private StockGroupDTO toDTO(StockGroup entity) {
        return new StockGroupDTO(
                entity.getId(),
                entity.getName(),
                entity.getTotalItems(),
                entity.getValue(),
                entity.getLowStock(),
                entity.getStatus(),
                entity.getResponsible());
    }

    private StockGroup toEntity(StockGroupDTO dto) {
        StockGroup entity = new StockGroup();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTotalItems(dto.getTotalItems());
        entity.setValue(dto.getValue());
        entity.setLowStock(dto.getLowStock());
        entity.setStatus(dto.getStatus());
        entity.setResponsible(dto.getResponsible());
        return entity;
    }
}
