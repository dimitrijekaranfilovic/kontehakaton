package org.konteh.kontehakatonbackend.controller;


import org.konteh.kontehakatonbackend.converter.DeskConverter;
import org.konteh.kontehakatonbackend.dto.CreateDeskDTO;
import org.konteh.kontehakatonbackend.dto.GetDeskDTO;
import org.konteh.kontehakatonbackend.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/desks")
public class DeskController {

    private final DeskService deskService;

    @Autowired
    public DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    //room je naziv citaonice
    @GetMapping
    public List<GetDeskDTO> getDesks(@RequestParam(name = "room") @Nullable String room) {
        return DeskConverter.toGetDeskDTOList(this.deskService.getDesksByRoomName(room));
    }

    @PostMapping
    public GetDeskDTO createDesk(@RequestBody CreateDeskDTO dto) {
        return DeskConverter.toGetDeskDTO(this.deskService.createDesk(dto.getRoomId()));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDesk(@PathVariable("id") String id) {
        this.deskService.deleteDeskById(id);
    }
}
