package org.konteh.kontehakatonbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "faculties")
@NoArgsConstructor
public class Faculty extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    private Set<Room> rooms = new HashSet<>(); //0, 1, ili vise

    @Column(name = "name")
    private String name;

    @Embedded
    @JsonProperty("working-hours")
    private WorkingHours workingHours;


    public Faculty(String name, WorkingHours workingHours) {
        this.name = name;
        this.workingHours = workingHours;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
        room.setFaculty(this);
    }
}
