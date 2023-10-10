package com.vibhusha.service;

import com.vibhusha.dto.ProductDTO;
import com.vibhusha.model.MongoDBInventory;
import com.vibhusha.repository.MongoDBInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoDBInventoryServiceImpl implements MongoDBInventoryService {
    @Autowired
    private MongoDBInventoryRepository repository;

    @Override
    public Optional<MongoDBInventory> getItemById(String itemId) {
        return repository.findById(itemId);
    }

    @Override
    public List<MongoDBInventory> searchItemsByName(String itemName) {
        return repository.findByItemNameContainingIgnoreCase(itemName);
    }

    @Override
    public MongoDBInventory createOrUpdateItem(MongoDBInventory item) {

        return repository.save(item);
    }

    @Override
    public void deleteItemById(String itemId) {
        repository.deleteById(itemId);
    }

    @Override
    public void createProductDTO(ProductDTO productDTO) {

    }
}
