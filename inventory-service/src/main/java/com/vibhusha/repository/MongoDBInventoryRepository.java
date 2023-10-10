package com.vibhusha.repository;

import com.vibhusha.model.MongoDBInventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoDBInventoryRepository extends MongoRepository<MongoDBInventory, String> {

    List<MongoDBInventory> findByItemNameContainingIgnoreCase(String itemName);
}
