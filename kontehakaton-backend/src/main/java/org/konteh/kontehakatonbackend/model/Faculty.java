package org.konteh.kontehakatonbackend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class Faculty extends BaseEntity {

    private Set<Room> rooms; //0, 1, ili vise

    private String name;

    private WorkingHours workingHours;
}
