package com.udaan.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
public class Deal {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer itemId;
    private Integer noOfTotalItems;
    private Integer noOfItemsSold;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private String dealStatus;
}
