package com.vibhusha.service;

import com.vibhusha.model.ElasticInventory;
import com.vibhusha.repository.ElasticsearchInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElasticsearchInventoryServiceImpl implements ElasticsearchInventoryService {
    @Autowired
    private ElasticsearchInventoryRepository repository;

    @Override
    public Optional<ElasticInventory> getItemByIdFromElasticsearch(String itemId) {
        return Optional.empty();
    }

    @Override
    public Optional<ElasticInventory> getItemById(String itemId) {
        return repository.findById(itemId);
    }

    @Override
    public List<ElasticInventory> searchItemsByName(String itemName) {
        return repository.findByItemNameContainingIgnoreCase(itemName);
    }

    @Override
    public void deleteItemById(String itemId) {
        repository.deleteById(itemId);
    }

    @Override
    public void createOrUpdateItem(ElasticInventory elasticItem) {
        // Implement the logic to create or update the item in Elasticsearch
        // You can use the Elasticsearch repository methods for this purpose
        // For example:
        // repository.save(elasticItem);
    }
}
