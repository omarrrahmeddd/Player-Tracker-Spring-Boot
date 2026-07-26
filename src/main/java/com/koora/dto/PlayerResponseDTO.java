package com.koora.dto;

import com.koora.entity.Club;
import com.koora.entity.Position;
import com.koora.entity.Nationality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class PlayerResponseDTO {
    private Integer id;
    private String name;
    private Club club;
    private Position position;
    private Set<Nationality> nationalities;
    private Double rating;


}