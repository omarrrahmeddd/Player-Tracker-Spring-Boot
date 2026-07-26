package com.koora.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClubResponseDTO {

    private Integer id;


    private String name;

    private Double budget;
}
