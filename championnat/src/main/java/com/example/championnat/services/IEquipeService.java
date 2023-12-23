package com.example.championnat.services;

import com.example.championnat.entitiesDto.EquipeDto;
import com.example.championnat.exceptions.NotFoundException;

import java.util.List;

public interface IEquipeService {
    public List<EquipeDto> getAllEquipe();
    public EquipeDto getEquipeById(Long id) throws NotFoundException;
    public EquipeDto saveEquipe(EquipeDto equipeDto);
    public List<EquipeDto> saveListEquipe(List<EquipeDto> equipeDtos);
    public EquipeDto updateEquipe (Long id, EquipeDto equipeDto) throws NotFoundException;
    public void deleteEquipe(Long id);
}
