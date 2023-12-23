package com.example.championnat.transformers;

import com.example.championnat.entities.Entreneur;
import com.example.championnat.entitiesDto.EntreneurDto;
import java.util.*;
import java.util.stream.Collectors;

public class EntreneurTransformer {
    public static EntreneurDto entityToDto(Entreneur entreneur){
        EntreneurDto entreneurDto = new EntreneurDto();
        entreneurDto.setId(entreneur.getId());
        entreneurDto.setGenre(entreneur.getGenre());
        entreneurDto.setNom(entreneur.getNom());
        entreneurDto.setPrenom(entreneur.getPrenom());
        entreneurDto.setContrat(entreneur.getContrat());
        entreneurDto.setAdresseEmail(entreneur.getAdresseEmail());
        entreneurDto.setNationalite(entreneur.getNationalite());
        entreneurDto.setDateNaissance(entreneur.getDateNaissance());
        entreneurDto.setNumeroDeTelephone(entreneur.getNumeroDeTelephone());
        entreneurDto.setDateDebutContrat(entreneur.getDateDebutContrat());

        return entreneurDto;
    }

    public static Entreneur dtoToEntity(EntreneurDto entreneurDto){
        Entreneur entreneur = new Entreneur();
        entreneur.setId(entreneurDto.getId());
        entreneur.setGenre(entreneurDto.getGenre());
        entreneur.setNom(entreneurDto.getNom());
        entreneur.setPrenom(entreneurDto.getPrenom());
        entreneur.setContrat(entreneurDto.getContrat());
        entreneur.setAdresseEmail(entreneurDto.getAdresseEmail());
        entreneur.setNationalite(entreneurDto.getNationalite());
        entreneur.setDateNaissance(entreneurDto.getDateNaissance());
        entreneur.setNumeroDeTelephone(entreneurDto.getNumeroDeTelephone());
        entreneur.setDateDebutContrat(entreneurDto.getDateDebutContrat());

        return entreneur;
    }

    public static List<EntreneurDto> entityToDtoList(List<Entreneur> entreneurs){
        return entreneurs.stream()
                .map(EntreneurTransformer::entityToDto)
                .collect(Collectors.toList());
    }

    public static List<Entreneur> dtoToEntityList(List<EntreneurDto> entreneurDtos){
        return entreneurDtos.stream()
                .map(EntreneurTransformer::dtoToEntity)
                .collect(Collectors.toList());
    }
}
