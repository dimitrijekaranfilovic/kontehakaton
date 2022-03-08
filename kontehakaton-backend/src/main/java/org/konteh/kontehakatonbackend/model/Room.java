package org.konteh.kontehakatonbackend.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "rooms")
@NoArgsConstructor
public class Room extends BaseEntity{

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Set<Desk> desks = new HashSet<>(); //mora imati barem 1 mjesto

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Faculty faculty;

    public Room(String name) {
        this.name = name;
    }

    public void addDesk(Desk desk){
        this.desks.add(desk);
        desk.setRoom(this);
    }

    public void removeDesk(Desk desk){
        this.desks.remove(desk);
        desk.setRoom(null);
    }
}
