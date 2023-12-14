package com.example.championnat.services.impl;

import com.example.championnat.entities.Equipe;
import com.example.championnat.entitiesDto.EquipeDto;
import com.example.championnat.exceptions.NotFoundException;
import com.example.championnat.repositories.IEquipeRepository;
import com.example.championnat.services.IEquipeService;
import com.example.championnat.transformers.EquipeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EquipeService {
    @Autowired
    private IEquipeRepository equipeRepository;

    public List<EquipeDto> getAllEquipe(){
        List<Equipe> equipes = equipeRepository.findAll();
        return EquipeTransformer.entityToDtoList(equipes);
    }

    public EquipeDto getEquipeById(Long id) throws NotFoundException {
        Equipe equipe = equipeRepository.findById(id).orElse(null);
        if(equipe != null){
            return EquipeTransformer.entityToDto(equipe);
        }else {
            throw new NotFoundException("il n y a pas d equipe avec id : "+ id);
        }
    }

    public EquipeDto saveEquipe(EquipeDto equipeDto){
        Equipe equipe = EquipeTransformer.dtoToEntity(equipeDto);
        equipeRepository.save(equipe);
        return EquipeTransformer.entityToDto(equipe);
    }

    public List<EquipeDto> saveListEquipe(List<EquipeDto> equipeDtos){
        List<Equipe> equipes = EquipeTransformer.dtoToEntityList(equipeDtos);
        equipeRepository.saveAll(equipes);
        return EquipeTransformer.entityToDtoList(equipes);
    }

    public EquipeDto updateEquipe (Long id, EquipeDto equipeDto) throws NotFoundException {
        Equipe equipe = equipeRepository.findById(id).orElse(null);
        if (equipe != null){
            equipe.setNomEquipe(equipeDto.getNomEquipe());
            equipe.setPaysEquipe(equipeDto.getPaysEquipe());
            equipe.setStatusEquipe(equipeDto.getStatusEquipe());
            equipe.setBudgetEquipe(equipeDto.getBudgetEquipe());
            equipe.setAnneFondation(equipeDto.getAnneFondation());

            return EquipeTransformer.entityToDto(equipe);
        }else {
            throw new NotFoundException("il n y a pas d equipe avec id : "+ id);
        }
    }

    public void deleteEquipe(Long id){
        equipeRepository.deleteById(id);
    }
}
