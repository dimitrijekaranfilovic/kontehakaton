package org.konteh.kontehakatonbackend.service;

import org.konteh.kontehakatonbackend.model.Room;
import org.konteh.kontehakatonbackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }
}
