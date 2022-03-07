package org.konteh.kontehakatonbackend.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Room extends BaseEntity{

    private Set<Desk> desks; //mora imati barem 1 mjesto

    private String name;

    //fakultet ostaviti?
    private Faculty faculty;
}
