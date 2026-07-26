package com.koora.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    @ManyToOne
    private Club club;
    private Position position;//enum


    @ManyToMany
    @JoinTable(
            name="player_nationality",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "nationality_id")

    )
    private Set<Nationality> nationalities;//lookup table



    @DecimalMin(value = "0.0", message = "Rating must be at least 0")
    @DecimalMax(value="10.0", message="Rating must be at most 10")
    private Double rating;

}
