package org.konteh.kontehakatonbackend.controller;


import org.konteh.kontehakatonbackend.model.Room;
import org.konteh.kontehakatonbackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    //faculty je naziv fakulteta
    @GetMapping
    public List<Room> getRooms(@RequestParam String faculty){
        return new ArrayList<>();
    }
}
