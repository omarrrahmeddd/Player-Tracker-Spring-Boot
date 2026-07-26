package com.koora;


public class PlayerResponseDTO {
    private Integer id;
    private String name;
    private String club;
    private String position;
    private String nationality;
    private Double rating;

    public PlayerResponseDTO(Integer id, String name, String club, String position, String nationality, Double rating) {
        this.id = id;
        this.name = name;
        this.club = club;
        this.position = position;
        this.nationality = nationality;
        this.rating = rating;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getClub() { return club; }
    public String getPosition() { return position; }
    public String getNationality() { return nationality; }
    public Double getRating() { return rating; }
}