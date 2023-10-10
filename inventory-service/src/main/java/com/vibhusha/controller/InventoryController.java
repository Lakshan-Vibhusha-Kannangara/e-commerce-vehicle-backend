package com.vibhusha.controller;

import com.vibhusha.model.ElasticInventory;
import com.vibhusha.model.MongoDBInventory;
import com.vibhusha.service.ElasticsearchInventoryService;
import com.vibhusha.service.MongoDBInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private MongoDBInventoryService mongoDBInventoryService;

    @Autowired
    private ElasticsearchInventoryService elasticsearchInventoryService;

    @PostMapping
    public MongoDBInventory createItem(@RequestBody MongoDBInventory item) {

        MongoDBInventory savedMongoDBItem = mongoDBInventoryService.createOrUpdateItem(item);


        ElasticInventory elasticItem = convertToElasticInventory(savedMongoDBItem);
        elasticsearchInventoryService.createOrUpdateItem(elasticItem);

        return savedMongoDBItem;
    }

    @GetMapping("/{itemId}")
    public Optional<ElasticInventory> getItemById(@PathVariable String itemId) {
        // Get from Elasticsearch
        return elasticsearchInventoryService.getItemById(itemId);
    }

    @GetMapping("/search")
    public List<MongoDBInventory> searchItemsByName(@RequestParam String itemName) {
        // Search in Elasticsearch
        List<ElasticInventory> elasticItems = elasticsearchInventoryService.searchItemsByName(itemName);

        // Convert Elasticsearch results to MongoDBInventory
        return convertToMongoDBInventoryList(elasticItems);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItemById(@PathVariable String itemId) {
        // Delete from MongoDB
        mongoDBInventoryService.deleteItemById(itemId);

        // Delete from Elasticsearch
        elasticsearchInventoryService.deleteItemById(itemId);
    }

    // Helper method to convert MongoDBInventory to ElasticInventory
    private ElasticInventory convertToElasticInventory(MongoDBInventory mongoDBItem) {
        ElasticInventory elasticItem = new ElasticInventory();
        elasticItem.setItemId(mongoDBItem.getItemId());
        elasticItem.setItemName(mongoDBItem.getItemName());
        elasticItem.setDescription(mongoDBItem.getDescription());
        // Map other fields as needed
        return elasticItem;
    }

    // Helper method to convert a list of ElasticInventory to MongoDBInventory
    private List<MongoDBInventory> convertToMongoDBInventoryList(List<ElasticInventory> elasticItems) {
        List<MongoDBInventory> mongoDBInventoryList = new ArrayList<>();

        for (ElasticInventory elasticItem : elasticItems) {
            MongoDBInventory mongoDBItem = new MongoDBInventory();
            mongoDBItem.setItemId(elasticItem.getItemId());
            mongoDBItem.setItemName(elasticItem.getItemName());
            mongoDBItem.setDescription(elasticItem.getDescription());
            mongoDBItem.setPhoto(elasticItem.getPhoto()); // Map other fields as needed
            mongoDBItem.setPrice(elasticItem.getPrice());
            mongoDBItem.setCreated(elasticItem.getCreated());
            mongoDBItem.setUserId(elasticItem.getUserId());

            mongoDBInventoryList.add(mongoDBItem);
        }

        return mongoDBInventoryList;
    }

}
