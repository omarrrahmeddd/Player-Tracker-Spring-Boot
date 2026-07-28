package com.koora.service;

import com.koora.dto.NationalityResponseDTO;
import com.koora.entity.Nationality;
import com.koora.exception.NotFoundException;
import com.koora.mapper.NationalityMapper;
import com.koora.repo.NationalityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalityService {
    private final NationalityRepo nationalityRepo;

    public NationalityService(NationalityRepo nationalityRepo) {
        this.nationalityRepo = nationalityRepo;
    }

    public List<NationalityResponseDTO> getALLNationalities(){
        return nationalityRepo.findAll()
                .stream()
                .map(NationalityMapper.INSTANCE::toDto)
                .toList();
    }
    public NationalityResponseDTO addNationality(Nationality mynationality){
        Nationality saveNationality =nationalityRepo.save(mynationality);
        return NationalityMapper.INSTANCE.toDto(saveNationality);
    }
    public NationalityResponseDTO getNationalityBYid(Integer id){
        Nationality saveNationality=nationalityRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Nationality Not Found"));
        return NationalityMapper.INSTANCE.toDto(saveNationality);
    }
    public NationalityResponseDTO updateNationality(Integer id , Nationality nationality){
        Nationality existingNationality=nationalityRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Nationality Not Found"));
        existingNationality.setName(nationality.getName());
        Nationality savedNationality = nationalityRepo.save(existingNationality);
        return NationalityMapper.INSTANCE.toDto(savedNationality);
    }
    public void deleteNationalityById(Integer id){
        nationalityRepo.deleteById(id);
    }
}
