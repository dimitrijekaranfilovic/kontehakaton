package org.konteh.kontehakatonbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.konteh.kontehakatonbackend.model.*;
import org.konteh.kontehakatonbackend.repository.DeskRepository;
import org.konteh.kontehakatonbackend.repository.FacultyRepository;
import org.konteh.kontehakatonbackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;


@Component
public class DataInitializer implements ApplicationRunner {
    private final DeskRepository deskRepository;

    private final FacultyRepository facultyRepository;

    private final RoomRepository roomRepository;

    private final ObjectMapper mapper;

    @Autowired
    public DataInitializer(DeskRepository deskRepository, FacultyRepository facultyRepository, RoomRepository roomRepository, ObjectMapper mapper) {
        this.deskRepository = deskRepository;
        this.facultyRepository = facultyRepository;
        this.roomRepository = roomRepository;
        this.mapper = mapper;
    }


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        var json = new File("src/main/resources/citaonice.json");
        FacultyContainer container = mapper.readValue(json, FacultyContainer.class);
        for (var faculty : container.getFaculties()) {
            this.facultyRepository.save(faculty);
            for (var room : faculty.getRooms()) {
                faculty.addRoom(room);
                this.roomRepository.save(room);
                for (var desk : room.getDesks()) {
                    room.addDesk(desk);
                    desk.setIsOccupied(false);
                    this.deskRepository.save(desk);
                }
            }
        }
    }
}
