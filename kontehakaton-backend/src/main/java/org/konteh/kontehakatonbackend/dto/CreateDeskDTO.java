package org.konteh.kontehakatonbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDeskDTO {

    @NotBlank(message = "Room id cannot be blank.")
    private String roomId;

}
