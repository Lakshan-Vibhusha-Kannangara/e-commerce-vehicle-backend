package com.vibhusha.service;

import com.vibhusha.model.ElasticInventory;

import java.util.List;
import java.util.Optional;

public interface ElasticsearchInventoryService {



    // Other methods...

    // Custom method to retrieve a document by its ID
    Optional<ElasticInventory> getItemByIdFromElasticsearch(String itemId);


    Optional<ElasticInventory> getItemById(String itemId);

    List<ElasticInventory> searchItemsByName(String itemName);

    void deleteItemById(String itemId);

    // Custom method for creating or updating an item in Elasticsearch
    void createOrUpdateItem(ElasticInventory elasticItem);
}
