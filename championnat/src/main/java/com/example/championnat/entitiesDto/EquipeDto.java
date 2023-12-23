package com.example.championnat.entitiesDto;

import com.example.championnat.entities.enums.StatusEquipe;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipeDto {
    private Long id;
    @NotBlank(message = "le champ ne doit pas etre blank")
    @NotNull(message = "le champ ne doit pas etre null")
    @NotEmpty(message = "le champ ne doit pas etre vide")
    private String nomEquipe;
    @NotBlank(message = "le champ ne doit pas etre blank")
    @NotNull(message = "le champ ne doit pas etre null")
    @NotEmpty(message = "le champ ne doit pas etre vide")
    private String paysEquipe;
    @NotBlank(message = "le champ ne doit pas etre blank")
    @NotNull(message = "le champ ne doit pas etre null")
    @NotEmpty(message = "le champ ne doit pas etre vide")
    @Pattern(regexp = "^\\d{4}$", message = "la saison doit etre de la facon suivant num exemple : (2024)")
    private String anneFondation;
    //image logo de l equipe
    //relation entrainneur
    //relation stade
    //relation joueur
    //relation sponsor
    //relation palmares
    //relation efictif actuel
//    @NotBlank(message = "le champ ne doit pas etre blank")
//    @NotNull(message = "le champ ne doit pas etre null")
//    @NotEmpty(message = "le champ ne doit pas etre vide")
    private Long budgetEquipe;
    private StatusEquipe statusEquipe;
    private ChampionnatDto championnatDto;
}
