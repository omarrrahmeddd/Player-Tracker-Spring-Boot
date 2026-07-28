package com.koora.controller;


import com.koora.dto.NationalityResponseDTO;
import com.koora.entity.Nationality;
import com.koora.service.NationalityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/nationalities")
public class NationalityController {
    private final NationalityService nationalityService;

    public NationalityController(NationalityService nationalityService) {
        this.nationalityService = nationalityService;
    }

    @GetMapping
    public List<NationalityResponseDTO> getALLNationalities(){
        return nationalityService.getALLNationalities();
    }
    @PostMapping
    public NationalityResponseDTO addNationality(@Valid @RequestBody Nationality mynationality){
        return nationalityService.addNationality(mynationality);

    }
    @GetMapping("/{id}")
    public NationalityResponseDTO getNationalityBYid(@PathVariable Integer id){
        return nationalityService.getNationalityBYid(id);
    }
    @PutMapping("/{id}")
    public NationalityResponseDTO updateNationality(@PathVariable Integer id ,@Valid @RequestBody Nationality nationality){
        return nationalityService.updateNationality(id,nationality);
    }
    @DeleteMapping("/{id}")
    public void deleteNationalityById(@PathVariable Integer id){
        nationalityService.deleteNationalityById(id);
    }
}
