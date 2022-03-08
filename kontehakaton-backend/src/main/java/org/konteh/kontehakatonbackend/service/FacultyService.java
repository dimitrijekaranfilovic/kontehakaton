package org.konteh.kontehakatonbackend.service;

import org.konteh.kontehakatonbackend.model.Faculty;
import org.konteh.kontehakatonbackend.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public List<Faculty> getAllFaculties() {
        return this.facultyRepository.findAll();
    }
}
