package org.konteh.kontehakatonbackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GenericGenerator(name = "id_generator", strategy = "org.konteh.kontehakatonbackend.util.IdGenerator")
    @GeneratedValue(generator = "id_generator")
    private String id;
}
