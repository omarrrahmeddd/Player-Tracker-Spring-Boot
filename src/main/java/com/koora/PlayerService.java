package com.koora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public List<PlayerResponseDTO> getAllPlayers(){
        return playerRepo.findAll()
         .stream()
                .map(player -> new PlayerResponseDTO(
                        player.getId(),
                        player.getName(),
                        player.getClub(),
                        player.getPosition(),
                        player.getNationality(),
                        player.getRating()
                ))
                .toList();

    }
    public Player createplayer(Player newplayer){

        return playerRepo.save(newplayer);

    }

    public Player getPlayerbyId (Integer id){
     return   playerRepo.findById(id)
        .orElseThrow(() -> new PlayerNotFoundException("player not found"));
    }
    public Player updateplayer (Integer id, Player myplayer){
       Player neededplayer = playerRepo.findById(id)
               .orElseThrow(() -> new PlayerNotFoundException("Player not found"));
       neededplayer.setName(myplayer.getName());
        neededplayer.setClub(myplayer.getClub());
        neededplayer.setNationality(myplayer.getNationality());
        neededplayer.setPosition(myplayer.getPosition());
        neededplayer.setRating(myplayer.getRating());
        return playerRepo.save(neededplayer);
    }
    public void deletplayerbyId(Integer id){
        playerRepo.deleteById(id);
    }
}
