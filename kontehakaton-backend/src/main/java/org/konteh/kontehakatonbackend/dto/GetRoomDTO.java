package org.konteh.kontehakatonbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.konteh.kontehakatonbackend.model.Room;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetRoomDTO {

     private String id;

     private String name;

     public GetRoomDTO(Room room) {
          this.id = room.getId();
          this.name = room.getName();
     }
}
