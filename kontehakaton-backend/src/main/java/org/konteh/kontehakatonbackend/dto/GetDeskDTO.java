package org.konteh.kontehakatonbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.konteh.kontehakatonbackend.model.Desk;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDeskDTO {

    private String id;

    private Boolean isOccupied;

    private Integer order;

    public GetDeskDTO(Desk desk) {
        this.id = desk.getId();
        this.isOccupied = desk.getIsOccupied();
        this.order = desk.getOrder();
    }

}
