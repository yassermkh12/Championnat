package com.example.championnat.services;

import com.example.championnat.entitiesDto.ChampionnatDto;

import java.util.List;

public interface IChampionnatService {
    public List<ChampionnatDto> getAllChampionnat();
    public ChampionnatDto getChampionnatById(Long id);
    public ChampionnatDto saveChampionnat(ChampionnatDto championnatDto);
    public List<ChampionnatDto> saveListChampionnat(List<ChampionnatDto> championnatDtos);
    public ChampionnatDto updateChampionnat(Long id,ChampionnatDto championnatDto);
    public void deleteChampionnat(Long id);
}
