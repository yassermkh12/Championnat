package com.example.championnat.transformers;

import com.example.championnat.entities.Championnat;
import com.example.championnat.entitiesDto.ChampionnatDto;
import java.util.*;
import java.util.stream.Collectors;

public class ChampionnatTransformer {
    public static ChampionnatDto entityToDto(Championnat championnat){
        ChampionnatDto championnatDto = new ChampionnatDto();
        championnatDto.setId(championnat.getId());
        championnatDto.setTypeChampionnat(championnat.getTypeChampionnat());
        championnatDto.setNomDuChampionnat(championnat.getNomDuChampionnat());
        championnatDto.setSaison(championnat.getSaison());
        championnatDto.setDateDebutChampionnat(championnat.getDateDebutChampionnat());
        championnatDto.setDateFinChampionnat(championnat.getDateFinChampionnat());

        return championnatDto;
    }
    public static Championnat dtoToEntity(ChampionnatDto championnatDto){
        Championnat championnat = new Championnat();
        championnat.setId(championnatDto.getId());
        championnat.setTypeChampionnat(championnatDto.getTypeChampionnat());
        championnat.setSaison(championnatDto.getSaison());
        championnat.setNomDuChampionnat(championnatDto.getNomDuChampionnat());
        championnat.setDateFinChampionnat(championnatDto.getDateFinChampionnat());
        championnat.setDateDebutChampionnat(championnatDto.getDateDebutChampionnat());

        return championnat;
    }
    public static List<ChampionnatDto> entityToDtoList(List<Championnat> championnats){
        return championnats.stream()
                .map(ChampionnatTransformer::entityToDto)
                .collect(Collectors.toList());
    }
    public static List<Championnat> dtoToEntityList(List<ChampionnatDto> championnatDtos){
        return championnatDtos.stream()
                .map(ChampionnatTransformer::dtoToEntity)
                .collect(Collectors.toList());
    }
}
