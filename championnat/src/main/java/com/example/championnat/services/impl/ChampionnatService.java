package com.example.championnat.services.impl;

import com.example.championnat.entities.Championnat;
import com.example.championnat.entitiesDto.ChampionnatDto;
import com.example.championnat.exceptions.NotFoundException;
import com.example.championnat.repositories.IChampionnatRepository;
import com.example.championnat.services.IChampionnatService;
import com.example.championnat.transformers.ChampionnatTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Slf4j
@Service
public class ChampionnatService implements IChampionnatService {
    @Autowired
    private IChampionnatRepository championnatRepository;

    public List<ChampionnatDto> getAllChampionnat(){
        List<Championnat> championnats = championnatRepository.findAll();
        log.info("les championnats dans la base de donnees sont : "+ championnats);
        return ChampionnatTransformer.entityToDtoList(championnats);
    }
    public ChampionnatDto getChampionnatById(Long id) throws NotFoundException {
        Championnat championnat = championnatRepository.findById(id).orElse(null);
        if(championnat != null) {
            log.info("le championnat avec l id : "+ id + " existe " + championnat);
            return ChampionnatTransformer.entityToDto(championnat);
        }else {
            log.info("il n y a pas de championnat avec id "+ id);
            throw new NotFoundException("Il n y a pas de championnat avec l id : "+ id);
        }
    }
    public ChampionnatDto saveChampionnat(ChampionnatDto championnatDto){
        Championnat championnat = ChampionnatTransformer.dtoToEntity(championnatDto);
        championnatRepository.save(championnat);
        log.info("le championnat est enregistres avec id : "+ championnat.getId());
        return ChampionnatTransformer.entityToDto(championnat);
    }
    public List<ChampionnatDto> saveListChampionnat(List<ChampionnatDto> championnatDtos){
        List<Championnat> championnats = ChampionnatTransformer.dtoToEntityList(championnatDtos);
        championnatRepository.saveAll(championnats);
        log.info("les championnats sont enregistres");
        return ChampionnatTransformer.entityToDtoList(championnats);
    }
    public ChampionnatDto updateChampionnat(Long id,ChampionnatDto championnatDto) throws NotFoundException {
        Championnat championnat = championnatRepository.findById(id).orElse(null);
        if(championnat != null){
            log.info("le championnat avec l id : "+ id + " existe " + championnat);
            championnat.setTypeChampionnat(championnatDto.getTypeChampionnat());
            championnat.setNomDuChampionnat(championnatDto.getNomDuChampionnat());
            championnat.setDateDebutChampionnat(championnatDto.getDateDebutChampionnat());
            championnat.setDateFinChampionnat(championnatDto.getDateFinChampionnat());
            championnat.setSaison(championnatDto.getSaison());

            log.info("le championnat est mis a jour "+ championnat);
            return ChampionnatTransformer.entityToDto(championnat);
        }else {
            log.info("il n y a pas de championnat avec id "+ id);
            throw new NotFoundException("Il n y a pas de championnat avec l id : "+ id);
        }
    }
    public void deleteChampionnat(Long id){
        championnatRepository.deleteById(id);
        log.info("le championnat avec id : "+ id + " est supprime");
    }
}
