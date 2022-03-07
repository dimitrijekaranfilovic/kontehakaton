package org.konteh.kontehakatonbackend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;


@Getter
@Setter
public class WorkingHours {

    private LocalTime opens;

    private LocalTime closes;
}
