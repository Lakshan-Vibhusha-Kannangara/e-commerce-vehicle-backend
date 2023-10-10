// MongoDB service
package com.vibhusha.service;

import com.vibhusha.dto.ProductDTO;
import com.vibhusha.model.MongoDBInventory;

import java.util.List;
import java.util.Optional;

public interface MongoDBInventoryService {

    Optional<MongoDBInventory> getItemById(String itemId);

    List<MongoDBInventory> searchItemsByName(String itemName);

    MongoDBInventory createOrUpdateItem(MongoDBInventory item);

    void deleteItemById(String itemId);

    void createProductDTO(ProductDTO productDTO);
}
