package com.example.championnat.controllers;

import com.example.championnat.entitiesDto.ChampionnatDto;
import com.example.championnat.services.IChampionnatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/championnat")
public class ChampionnatController {
    @Autowired
    private IChampionnatService championnatService;
    @GetMapping("/all")
    public ResponseEntity<List<ChampionnatDto>> getAllChampionnat(){
        List<ChampionnatDto> championnatDtos = championnatService.getAllChampionnat();
        return new ResponseEntity<>(championnatDtos, HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<ChampionnatDto> getChampionnatById(@PathVariable Long id){
        ChampionnatDto championnatDto = championnatService.getChampionnatById(id);
        return new ResponseEntity<>(championnatDto,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ChampionnatDto> saveChampionnat(@RequestBody ChampionnatDto championnatDto){
        ChampionnatDto createChampionnatDto = championnatService.saveChampionnat(championnatDto);
        return new ResponseEntity<>(createChampionnatDto,HttpStatus.CREATED);
    }
    @PostMapping("/saveList")
    public ResponseEntity<List<ChampionnatDto>> saveListChampionnat(@RequestBody List<ChampionnatDto> championnatDtos){
        List<ChampionnatDto> createChampionnatDtoList = championnatService.saveListChampionnat(championnatDtos);
        return new ResponseEntity<>(createChampionnatDtoList,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ChampionnatDto> updateChampionnat(@PathVariable Long id, @RequestBody ChampionnatDto championnatDto){
        ChampionnatDto updateChampionnatDto = championnatService.updateChampionnat(id, championnatDto);
        return new ResponseEntity<>(updateChampionnatDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChampionnat(@PathVariable Long id){
        championnatService.deleteChampionnat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
