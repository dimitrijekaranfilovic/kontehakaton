package org.konteh.kontehakatonbackend.service;

import org.konteh.kontehakatonbackend.exception.NotFoundException;
import org.konteh.kontehakatonbackend.model.Desk;
import org.konteh.kontehakatonbackend.repository.DeskRepository;
import org.konteh.kontehakatonbackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskService {

    private final DeskRepository deskRepository;

    private final RoomRepository roomRepository;

    @Autowired
    public DeskService(DeskRepository deskRepository, RoomRepository roomRepository) {
        this.deskRepository = deskRepository;
        this.roomRepository = roomRepository;
    }

    public List<Desk> getDesksByRoomName(String room) {
        String name = room == null ? "" : room;
        return this.deskRepository.getDesksByRoomName(name);
    }

    public Desk createDesk(String roomId) {
        var room = this.roomRepository.findById(roomId)
                .orElseThrow(() -> new NotFoundException(String.format("Room with id: %s not found.", roomId)));
        var desk = new Desk(room, this.getNextDeskOrder(roomId));
        return this.deskRepository.save(desk);
    }

    public void deleteDeskById(String id) {
        var desk = this.deskRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(String.format("Desk with id: %s does not exist.", id)));
        this.deskRepository.deleteById(desk.getId());
    }

    private int getNextDeskOrder(String roomId) {
        return this.deskRepository.countDesksForRoom(roomId);
    }


}
