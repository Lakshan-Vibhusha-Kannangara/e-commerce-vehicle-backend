package com.vibhusha.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String itemName;
    private String description;
    private String photo;
    private BigDecimal price;
    private Long userId;
    private Date created;
}
