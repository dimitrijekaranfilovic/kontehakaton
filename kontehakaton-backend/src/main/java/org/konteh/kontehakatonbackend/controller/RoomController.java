package org.konteh.kontehakatonbackend.controller;


import org.konteh.kontehakatonbackend.converter.RoomConverter;
import org.konteh.kontehakatonbackend.dto.GetRoomDTO;
import org.konteh.kontehakatonbackend.model.Room;
import org.konteh.kontehakatonbackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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
    public List<GetRoomDTO> getRooms(@RequestParam(name = "faculty") @Nullable String faculty){
        if (faculty == null)
            return RoomConverter.toGetRoomDTOList(this.roomService.getAllRooms());
        //ovdje dobavi po imenu
        return new ArrayList<>();
    }
}
