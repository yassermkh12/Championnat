package com.example.championnat.controllers;

import com.example.championnat.entitiesDto.EquipeDto;
import com.example.championnat.exceptions.NotFoundException;
import com.example.championnat.services.IEquipeService;
import com.example.championnat.services.impl.EquipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/equipe")
public class EquipeController {
    @Autowired
    private IEquipeService equipeService;
    @GetMapping("/all")
    public ResponseEntity<List<EquipeDto>> getAllEquipe(){
        List<EquipeDto> equipeDto = equipeService.getAllEquipe();
        return new ResponseEntity<>(equipeDto, HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<EquipeDto> getEquipeById(@PathVariable Long id) throws NotFoundException {
        EquipeDto equipeDto = equipeService.getEquipeById(id);
        return new ResponseEntity<>(equipeDto,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<EquipeDto> saveEquipe(@RequestBody @Valid EquipeDto equipeDto){
        EquipeDto createEquipeDto = equipeService.saveEquipe(equipeDto);
        return new ResponseEntity<>(createEquipeDto,HttpStatus.CREATED);
    }
    @PostMapping("/saveAll")
    public ResponseEntity<List<EquipeDto>> saveListEquipe(@RequestBody @Valid List<EquipeDto> equipeDtos){
        List<EquipeDto> createEquipeDtos = equipeService.saveListEquipe(equipeDtos);
        return new ResponseEntity<>(createEquipeDtos,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EquipeDto> updateEquipe(@PathVariable Long id,@RequestBody @Valid EquipeDto equipeDto) throws NotFoundException {
        EquipeDto updateEquipeDto = equipeService.updateEquipe(id,equipeDto);
        return new ResponseEntity<>(updateEquipeDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id){
        equipeService.deleteEquipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
