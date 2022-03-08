package org.konteh.kontehakatonbackend.controller;


import org.konteh.kontehakatonbackend.converter.FacultyConverter;
import org.konteh.kontehakatonbackend.dto.GetFacultyDTO;
import org.konteh.kontehakatonbackend.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetFacultyDTO> getFaculties(){
        return FacultyConverter.toGetFacultyDTOList(this.facultyService.getAllFaculties());
    }
}
