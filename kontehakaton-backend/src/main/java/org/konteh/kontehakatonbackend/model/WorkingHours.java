package org.konteh.kontehakatonbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalTime;


@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class WorkingHours {

    @Column(name = "opens")
    private LocalTime opens;

    @Column(name = "closes")
    private LocalTime closes;


    public WorkingHours(LocalTime opens, LocalTime closes) {
        this.opens = opens;
        this.closes = closes;
    }
}
