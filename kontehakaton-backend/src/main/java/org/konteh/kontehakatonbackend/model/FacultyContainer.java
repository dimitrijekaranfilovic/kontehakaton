package org.konteh.kontehakatonbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FacultyContainer {

    List<Faculty> faculties = new ArrayList<>();
}
