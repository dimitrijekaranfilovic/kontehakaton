package org.konteh.kontehakatonbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.konteh.kontehakatonbackend.model.Faculty;
import org.konteh.kontehakatonbackend.model.WorkingHours;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetFacultyDTO {

    private String id;

    private String name;

    private WorkingHours workingHours;

    public GetFacultyDTO(Faculty faculty) {
        this.id = faculty.getId();
        this.name = faculty.getName();
        this.workingHours = faculty.getWorkingHours();
    }
}
