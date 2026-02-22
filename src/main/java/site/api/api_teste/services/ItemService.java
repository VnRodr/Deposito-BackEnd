package site.api.api_teste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import site.api.api_teste.dtos.ItemDTO;
import site.api.api_teste.entities.Item;
import site.api.api_teste.enums.HttpsStatusCodes;
import site.api.api_teste.reposities.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public List<ItemDTO> findAll() {
        List<Item> itemEntityList = itemRepository.findAll();
        List<ItemDTO> itemDTOList = new ArrayList<>();

        for (Item item : itemEntityList) {
            itemDTOList.add(toDTO(item));
        }

        return itemDTOList;
    }

    @Transactional
    public ItemDTO findById(String id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpsStatusCodes.NotFoundStatus(), "Item not found"));

        return toDTO(item);
    }

    @Transactional
    public ItemDTO saveEntity(ItemDTO dto) {
        Item entity = toEntity(dto);
        Item savedEntity = itemRepository.save(entity);
        return toDTO(savedEntity);
    }

    @Transactional
    public ItemDTO changeEntity(ItemDTO dto) {
        Item entity = toEntity(dto);
        Item savedEntity = itemRepository.save(entity);
        return toDTO(savedEntity);
    }

    @Transactional
    public void deleteEntity(String id) {
        itemRepository.deleteById(id);
    }

    private ItemDTO toDTO(Item entity) {
        return new ItemDTO(entity.getId(), entity.getSKU(), entity.getName(), entity.getCategory(),
                entity.getQuantity(), entity.getUnitValue(), entity.getLowQuantity());
    }

    private Item toEntity(ItemDTO dto) {
        Item entity = new Item();
        entity.setId(dto.getId());
        entity.setSKU(dto.getSKU());
        entity.setName(dto.getName());
        entity.setCategory(dto.getCategory());
        entity.setQuantity(dto.getQuantity());
        entity.setUnitValue(dto.getUnitValue());
        entity.setLowQuantity(dto.getLowQuantity());
        return entity;
    }
}
