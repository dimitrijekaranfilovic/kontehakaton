package org.konteh.kontehakatonbackend.converter;

import org.konteh.kontehakatonbackend.dto.GetFacultyDTO;
import org.konteh.kontehakatonbackend.model.Faculty;

import java.util.List;
import java.util.stream.Collectors;

public class FacultyConverter {


    private FacultyConverter() {
        throw new IllegalStateException("FacultyConverter cannot be instantiated.");
    }


    public static GetFacultyDTO toGetFacultyDTO(Faculty faculty) {
        return new GetFacultyDTO(faculty);
    }

    public static List<GetFacultyDTO> toGetFacultyDTOList(List<Faculty> faculties) {
        return faculties.stream().map(FacultyConverter::toGetFacultyDTO).collect(Collectors.toList());
    }

}
