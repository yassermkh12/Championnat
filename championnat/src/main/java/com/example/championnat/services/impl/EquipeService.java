package com.example.championnat.services.impl;

import com.example.championnat.entities.Equipe;
import com.example.championnat.entitiesDto.EquipeDto;
import com.example.championnat.exceptions.NotFoundException;
import com.example.championnat.repositories.IEquipeRepository;
import com.example.championnat.services.IEquipeService;
import com.example.championnat.transformers.EquipeTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Slf4j
@Service
public class EquipeService implements IEquipeService {
    @Autowired
    private IEquipeRepository equipeRepository;

    public List<EquipeDto> getAllEquipe(){
        List<Equipe> equipes = equipeRepository.findAll();
        log.info("les equipes dans la base de donnees sont : "+ equipes);
        return EquipeTransformer.entityToDtoList(equipes);
    }

    public EquipeDto getEquipeById(Long id) throws NotFoundException {
        Equipe equipe = equipeRepository.findById(id).orElse(null);
        if(equipe != null){
            log.info("l equipe avec l id : "+ id + " existe " + equipe);
            return EquipeTransformer.entityToDto(equipe);
        }else {
            log.info("il n y a pas d equipe avec id "+ id);
            throw new NotFoundException("il n y a pas d equipe avec id : "+ id);
        }
    }

    public EquipeDto saveEquipe(EquipeDto equipeDto){
        Equipe equipe = EquipeTransformer.dtoToEntity(equipeDto);
        equipeRepository.save(equipe);
        log.info("l equipe est enregistres avec id : "+ equipe.getId());
        return EquipeTransformer.entityToDto(equipe);
    }

    public List<EquipeDto> saveListEquipe(List<EquipeDto> equipeDtos){
        List<Equipe> equipes = EquipeTransformer.dtoToEntityList(equipeDtos);
        equipeRepository.saveAll(equipes);
        log.info("les equipes sont enregistres");
        return EquipeTransformer.entityToDtoList(equipes);
    }

    public EquipeDto updateEquipe (Long id, EquipeDto equipeDto) throws NotFoundException {
        Equipe equipe = equipeRepository.findById(id).orElse(null);
        if (equipe != null){
            log.info("l equipe avec l id : "+ id + " existe " + equipe);
            equipe.setNomEquipe(equipeDto.getNomEquipe());
            equipe.setPaysEquipe(equipeDto.getPaysEquipe());
            equipe.setStatusEquipe(equipeDto.getStatusEquipe());
            equipe.setBudgetEquipe(equipeDto.getBudgetEquipe());
            equipe.setAnneFondation(equipeDto.getAnneFondation());

            equipeRepository.save(equipe);
            log.info("l equipe est mis a jour "+ equipe);
            return EquipeTransformer.entityToDto(equipe);
        }else {
            log.info("il n y a pas d equipe avec id "+ id);
            throw new NotFoundException("il n y a pas d equipe avec id : "+ id);
        }
    }

    public void deleteEquipe(Long id){
        equipeRepository.deleteById(id);
        log.info("l equipe avec id : "+ id + " est supprime");
    }
}
