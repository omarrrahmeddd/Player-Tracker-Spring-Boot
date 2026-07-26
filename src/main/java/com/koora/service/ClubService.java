package com.koora.service;

import com.koora.dto.ClubResponseDTO;
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
}
