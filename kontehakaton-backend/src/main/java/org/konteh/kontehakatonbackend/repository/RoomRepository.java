package org.konteh.kontehakatonbackend.repository;

import org.konteh.kontehakatonbackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {


    @Query(value = "select r from Room r where r.faculty.name like concat('%', :faculty, '%') order by r.name")
    List<Room> findByFacultyName(@Param("faculty") String faculty);
}
