package org.konteh.kontehakatonbackend.repository;


import org.konteh.kontehakatonbackend.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeskRepository extends JpaRepository<Desk, String> {

    @Query("select d from Desk d where d.room.name like concat('%', :room, '%') order by d.order")
    List<Desk> getDesksByRoomName(@Param("room") String room);

    @Query("select count(d) from Desk d where d.room.id = :room")
    int countDesksForRoom(@Param("room") String room);
}
