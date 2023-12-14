package com.example.championnat.transformers;

import com.example.championnat.entities.Equipe;
import com.example.championnat.entitiesDto.EquipeDto;
import java.util.*;
import java.util.stream.Collectors;

public class EquipeTransformer {
    public static EquipeDto entityToDto(Equipe equipe){
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(equipe.getId());
        equipeDto.setNomEquipe(equipe.getNomEquipe());
        equipeDto.setBudgetEquipe(equipe.getBudgetEquipe());
        equipeDto.setPaysEquipe(equipe.getPaysEquipe());
        equipeDto.setStatusEquipe(equipe.getStatusEquipe());
        equipeDto.setAnneFondation(equipe.getAnneFondation());

        return equipeDto;
    }
    public static Equipe dtoToEntity(EquipeDto equipeDto){
        Equipe equipe = new Equipe();
        equipe.setId(equipeDto.getId());
        equipe.setBudgetEquipe(equipeDto.getBudgetEquipe());
        equipe.setStatusEquipe(equipeDto.getStatusEquipe());
        equipe.setPaysEquipe(equipeDto.getPaysEquipe());
        equipe.setNomEquipe(equipeDto.getNomEquipe());
        equipe.setAnneFondation(equipeDto.getAnneFondation());

        return equipe;
    }
    public static List<EquipeDto> entityToDtoList(List<Equipe> equipes){
        return equipes.stream()
                .map(EquipeTransformer::entityToDto)
                .collect(Collectors.toList());
    }
    public static List<Equipe> dtoToEntityList(List<EquipeDto> equipeDtos){
        return equipeDtos.stream()
                .map(EquipeTransformer::dtoToEntity)
                .collect(Collectors.toList());
    }
}
