package com.koora.controller;


import com.koora.dto.ClubResponseDTO;
import com.koora.service.ClubService;
import com.koora.entity.Club;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clubs")
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public List<ClubResponseDTO> getAllClubs(){
        return clubService.getAllClubs();
    }
    @GetMapping("/{id}")
    public ClubResponseDTO getClubBYid(@PathVariable Integer id){
        return clubService.getClubBYid(id);
    }

    @PostMapping
    public ClubResponseDTO createClub(@RequestBody @Valid Club newClub){
        return clubService.createClub(newClub);
    }
    @PutMapping("/{id}")
    public ClubResponseDTO updateClub(@PathVariable Integer id,@RequestBody @Valid Club updatedClub){
        return clubService.updateClub(id, updatedClub);
    }
    @DeleteMapping("/{id}")
    public void deleteClubBYid(@PathVariable Integer id){
        clubService.deleteClubBYid(id);
    }

}
