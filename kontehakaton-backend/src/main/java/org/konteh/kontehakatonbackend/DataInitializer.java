package org.konteh.kontehakatonbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.konteh.kontehakatonbackend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;


@Component
public class DataInitializer implements ApplicationRunner {

    @PersistenceContext
    private final EntityManager entityManager;

    private final ObjectMapper mapper;

    @Autowired
    public DataInitializer(EntityManager entityManager, ObjectMapper mapper) {
        this.entityManager = entityManager;
        this.mapper = mapper;
    }


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        var json = new File("src/main/resources/citaonice.json");
        FacultyContainer container = mapper.readValue(json, FacultyContainer.class);
        for (var faculty : container.getFaculties()) {
            this.entityManager.merge(faculty);
            for (var room : faculty.getRooms()) {
                faculty.addRoom(room);
                this.entityManager.merge(room);
                for (var desk : room.getDesks()) {
                    room.addDesk(desk);
                    desk.setIsOccupied(false);
                    this.entityManager.merge(desk);
                }
            }
        }
    }
}
