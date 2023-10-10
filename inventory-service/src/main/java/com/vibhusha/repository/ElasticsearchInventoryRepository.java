package com.vibhusha.repository;

import com.vibhusha.model.ElasticInventory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticsearchInventoryRepository extends ElasticsearchRepository<ElasticInventory, String> {

    List<ElasticInventory> findByItemNameContainingIgnoreCase(String itemName);
}