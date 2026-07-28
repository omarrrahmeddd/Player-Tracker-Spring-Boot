package com.koora.service;

import com.koora.dto.ClubResponseDTO;
import com.koora.exception.NotFoundException;
import com.koora.mapper.ClubMapper;
import com.koora.repo.ClubRepo;
import com.koora.entity.Club;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    private final ClubRepo clubRepo;

    public ClubService(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }
    public List <ClubResponseDTO> getAllClubs(){
        return clubRepo.findAll()
                .stream()
                .map(ClubMapper.INSTANCE::toDto)
                .toList();

    }
    public ClubResponseDTO createClub(Club newClub){
        Club saveClub = clubRepo.save(newClub);
        return ClubMapper.INSTANCE.toDto(saveClub);
    }

    public ClubResponseDTO getClubBYid(Integer id){
        Club saveClub=clubRepo.findById(id)
                .orElseThrow(()->new NotFoundException("Club Not Found"));
        return ClubMapper.INSTANCE.toDto(saveClub);
    }
    public ClubResponseDTO updateClub(Integer id,Club updatedClub)
    {
        Club existingClub =clubRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Club not found"));
        existingClub.setName(updatedClub.getName());
        existingClub.setBudget(updatedClub.getBudget());
        Club savedClub=clubRepo.save(existingClub);
        return ClubMapper.INSTANCE.toDto(savedClub);

    }
    public void deleteClubBYid(Integer id){
         clubRepo.deleteById(id);
    }

}
