package com.koora.controller;


import com.koora.dto.PlayerResponseDTO;
import com.koora.service.PlayerService;
import com.koora.entity.Player;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;

    }
    @GetMapping
    public List<PlayerResponseDTO> getAllPlayers(){
        return playerService.getAllPlayers();
    }
    @PostMapping
    public PlayerResponseDTO createplayer(@Valid @RequestBody Player newplayer){
        return playerService.createplayer(newplayer);
    }
    @GetMapping("/{id}")
    public PlayerResponseDTO getPlayerbyId (@PathVariable Integer id){
        return playerService.getPlayerbyId(id);
    }

    @PutMapping("/{id}")
    public PlayerResponseDTO updateplayer ( @PathVariable   Integer id,@Valid @RequestBody Player myplayer){
      return  playerService.updateplayer(id, myplayer);
    }
    @DeleteMapping("/{id}")
    public void deletplayerbyId(@PathVariable Integer id){
        playerService.deletplayerbyId(id);
    }



}
