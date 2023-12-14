package com.example.championnat.controllers;

import com.example.championnat.entitiesDto.EquipeDto;
import com.example.championnat.services.impl.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
@RequestMapping("/api/equipe")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;
    @GetMapping("/all")
    public ResponseEntity<List<EquipeDto>> getAllEquipe(){
        List<EquipeDto> equipeDto = equipeService.getAllEquipe();
        return new ResponseEntity<>(equipeDto, HttpStatus.OK);
    }

}
