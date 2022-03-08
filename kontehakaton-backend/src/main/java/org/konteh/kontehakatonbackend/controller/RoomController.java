package org.konteh.kontehakatonbackend.controller;


import org.konteh.kontehakatonbackend.converter.RoomConverter;
import org.konteh.kontehakatonbackend.dto.GetRoomDTO;
import org.konteh.kontehakatonbackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.OK)
    public List<GetRoomDTO> getRooms(@RequestParam(name = "faculty") @Nullable String faculty){
        return RoomConverter.toGetRoomDTOList(this.roomService.getRoomsByFacultyName(faculty));
    }
}
