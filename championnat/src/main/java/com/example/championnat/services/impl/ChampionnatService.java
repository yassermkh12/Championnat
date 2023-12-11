package com.example.championnat.services.impl;

import com.example.championnat.entities.Championnat;
import com.example.championnat.entitiesDto.ChampionnatDto;
import com.example.championnat.exceptions.NotFoundException;
import com.example.championnat.repositories.IChampionnatRepository;
import com.example.championnat.services.IChampionnatService;
import com.example.championnat.transformers.ChampionnatTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChampionnatService implements IChampionnatService {
    @Autowired
    private IChampionnatRepository championnatRepository;

    public List<ChampionnatDto> getAllChampionnat(){
        List<Championnat> championnats = championnatRepository.findAll();
        return ChampionnatTransformer.entityToDtoList(championnats);
    }
    public ChampionnatDto getChampionnatById(Long id) throws NotFoundException {
        Championnat championnat = championnatRepository.findById(id).orElse(null);
        if(championnat != null) {
            return ChampionnatTransformer.entityToDto(championnat);
        }else {
            throw new NotFoundException("Il n y a pas de championnat avec l id : "+ id);
        }
    }
    public ChampionnatDto saveChampionnat(ChampionnatDto championnatDto){
        Championnat championnat = ChampionnatTransformer.dtoToEntity(championnatDto);
        championnatRepository.save(championnat);
        return ChampionnatTransformer.entityToDto(championnat);
    }
    public List<ChampionnatDto> saveListChampionnat(List<ChampionnatDto> championnatDtos){
        List<Championnat> championnats = ChampionnatTransformer.dtoToEntityList(championnatDtos);
        championnatRepository.saveAll(championnats);
        return ChampionnatTransformer.entityToDtoList(championnats);
    }
    public ChampionnatDto updateChampionnat(Long id,ChampionnatDto championnatDto) throws NotFoundException {
        Championnat championnat = championnatRepository.findById(id).orElse(null);
        if(championnat != null){
            championnat.setTypeChampionnat(championnatDto.getTypeChampionnat());
            championnat.setNomDuChampionnat(championnatDto.getNomDuChampionnat());
            championnat.setDateDebutChampionnat(championnatDto.getDateDebutChampionnat());
            championnat.setDateFinChampionnat(championnatDto.getDateFinChampionnat());
            championnat.setSaison(championnatDto.getSaison());

            return ChampionnatTransformer.entityToDto(championnat);
        }else {
            throw new NotFoundException("Il n y a pas de championnat avec l id : "+ id);
        }
    }
    public void deleteChampionnat(Long id){
        championnatRepository.deleteById(id);
    }
}
