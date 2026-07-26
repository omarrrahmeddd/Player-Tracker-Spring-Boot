package com.koora;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private Integer id;

    @NotBlank
    private String name;
    @NotBlank
    private String club;
    private String position;
    private String nationality;
    @DecimalMin(value = "0.0", message = "Rating must be at least 0")
    @DecimalMax(value="10.0", message="Rating must be at most 10")
    private Double rating;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(club, player.club) && Objects.equals(position, player.position) && Objects.equals(nationality, player.nationality) && Objects.equals(rating, player.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, club, position, nationality, rating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Player() {
    }

    public Player(Integer id, String name, String club, String nationality, String position, Double rating) {
        this.id = id;
        this.name = name;
        this.club = club;
        this.nationality = nationality;
        this.position = position;
        this.rating = rating;
    }

}
