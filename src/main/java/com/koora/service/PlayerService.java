package com.koora.service;

import com.koora.exception.PlayerNotFoundException;
import com.koora.dto.PlayerResponseDTO;
import com.koora.repo.PlayerRepo;
import com.koora.entity.Player;
import org.springframework.stereotype.Service;
import com.koora.mapper.PlayerMapper;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;


    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public List<PlayerResponseDTO> getAllPlayers(){
        return playerRepo.findAll()
                .stream()
                .map(PlayerMapper.INSTANCE::toDto)
                .toList();
    }
    public PlayerResponseDTO createplayer(Player newplayer){

        Player savePlayer = playerRepo.save(newplayer);
        return PlayerMapper.INSTANCE.toDto(savePlayer);

    }

    public PlayerResponseDTO getPlayerbyId (Integer id){
     Player savePlayer=   playerRepo.findById(id)
        .orElseThrow(() -> new PlayerNotFoundException("player not found"));
     return PlayerMapper.INSTANCE.toDto(savePlayer);
    }
    public PlayerResponseDTO updateplayer (Integer id, Player myplayer){
        Player neededplayer = playerRepo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));
        neededplayer.setName(myplayer.getName());
        neededplayer.setClub(myplayer.getClub());
        neededplayer.setNationalities(myplayer.getNationalities());
        neededplayer.setPosition(myplayer.getPosition());
        neededplayer.setRating(myplayer.getRating());
        Player savePlayer= playerRepo.save(neededplayer);
        return PlayerMapper.INSTANCE.toDto(savePlayer);
    }
    public void deletplayerbyId(Integer id){
        playerRepo.deleteById(id);
    }
}
