package com.example.championnat.entitiesDto;

import com.example.championnat.entities.enums.StatusEquipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipeDto {
    private Long id;
    private String nomEquipe;
    private String paysEquipe;
    private String anneFondation;
    //image logo de l equipe
    //relation entrainneur
    //relation stade
    //relation joueur
    //relation sponsor
    //relation palmares
    //relation efictif actuel
    private String budgetEquipe;
    private StatusEquipe statusEquipe;
}
