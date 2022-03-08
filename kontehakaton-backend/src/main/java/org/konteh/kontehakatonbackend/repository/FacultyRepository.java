package org.konteh.kontehakatonbackend.repository;

import org.konteh.kontehakatonbackend.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {
}
