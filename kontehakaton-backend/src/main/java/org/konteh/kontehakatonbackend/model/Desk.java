package org.konteh.kontehakatonbackend.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Desk extends BaseEntity {

    private Boolean isOccupied;

    private Room room;

    private Integer order;
}
