package org.konteh.kontehakatonbackend.converter;

import org.konteh.kontehakatonbackend.dto.GetDeskDTO;
import org.konteh.kontehakatonbackend.model.Desk;

import java.util.List;
import java.util.stream.Collectors;

public class DeskConverter {

    private DeskConverter() {
        throw new IllegalStateException("DeskConverter cannot be instantiated.");
    }

    public static GetDeskDTO toGetDeskDTO(Desk desk) {
        return new GetDeskDTO(desk);
    }

    public static List<GetDeskDTO> toGetDeskDTOList(List<Desk> desks) {
        return desks.stream().map(DeskConverter::toGetDeskDTO).collect(Collectors.toList());
    }
}
