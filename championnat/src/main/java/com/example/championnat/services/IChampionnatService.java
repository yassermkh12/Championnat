package com.example.championnat.services;

import com.example.championnat.entitiesDto.ChampionnatDto;
import com.example.championnat.exceptions.NotFoundException;

import java.util.List;

public interface IChampionnatService {
    public List<ChampionnatDto> getAllChampionnat();
    public ChampionnatDto getChampionnatById(Long id) throws NotFoundException;
    public ChampionnatDto saveChampionnat(ChampionnatDto championnatDto);
    public List<ChampionnatDto> saveListChampionnat(List<ChampionnatDto> championnatDtos);
    public ChampionnatDto updateChampionnat(Long id,ChampionnatDto championnatDto) throws NotFoundException;
    public void deleteChampionnat(Long id);
}
