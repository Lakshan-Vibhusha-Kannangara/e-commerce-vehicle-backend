package com.vibhusha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MongoDBInventory {

    @Id
    private String itemId;

    @Field("itemName")
    private String itemName;

    @Field("description")
    private String description;

    @Field("photo")
    private String photo;

    @Field("price")
    private BigDecimal price;

    @Field("created")
    private Date created;

    @Field("userId")
    private Long userId;

    // Constructors, getters, and setters
}