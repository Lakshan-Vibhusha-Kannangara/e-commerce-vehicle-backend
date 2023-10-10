package com.vibhusha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

@Document(indexName = "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElasticInventory {

    @Id
    private String itemId;

    @Field(type = FieldType.Text, name = "itemName", fielddata = true)
    private String itemName;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @Field(type = FieldType.Text, name = "photo")
    private String photo;

    @Field(type = FieldType.Double, name = "price")
    private BigDecimal price;

    @Field(type = FieldType.Date, name = "created")
    private Date created;

    @Field(type = FieldType.Long, name = "userId")
    private Long userId;

    // Constructors, getters, and setters
}