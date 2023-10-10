package com.vibhusha.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class InventoryDTO {


    private String itemName;
    private String description;
    private String photo;
    private BigDecimal price;
    private Long userId;
    private Date created;

}
