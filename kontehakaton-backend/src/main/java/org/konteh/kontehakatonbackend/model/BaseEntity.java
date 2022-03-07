package org.konteh.kontehakatonbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    private String id;
}
