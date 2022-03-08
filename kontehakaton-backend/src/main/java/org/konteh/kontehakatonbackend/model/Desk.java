package org.konteh.kontehakatonbackend.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "desks")
@NoArgsConstructor
public class Desk extends BaseEntity {

    @Column(name = "is_occupied")
    private Boolean isOccupied;

    @ManyToOne
    private Room room;

    @Column(name = "desk_order")
    private Integer order;

    public Desk(Integer order) {
        this.order = order;
        this.isOccupied = false;
    }
}
