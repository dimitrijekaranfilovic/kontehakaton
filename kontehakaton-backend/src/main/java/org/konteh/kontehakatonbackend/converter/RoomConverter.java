package org.konteh.kontehakatonbackend.converter;


import org.konteh.kontehakatonbackend.dto.GetRoomDTO;
import org.konteh.kontehakatonbackend.model.Room;

import java.util.List;
import java.util.stream.Collectors;

public class RoomConverter {

    private RoomConverter() {
        throw new IllegalStateException("RoomConverter cannot be instantiated.");
    }

    public static GetRoomDTO toGetRoomDTO(Room room) {
        return new GetRoomDTO(room);
    }

    public static List<GetRoomDTO> toGetRoomDTOList(List<Room> rooms) {
        return rooms.stream().map(RoomConverter::toGetRoomDTO).collect(Collectors.toList());
    }

}
