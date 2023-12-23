package com.example.championnat.entitiesDto;

import com.example.championnat.entities.Equipe;
import com.example.championnat.entities.enums.TypeChampionnat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampionnatDto {
    private Long id;
    @NotBlank(message = "le champ ne doit pas etre blank")
    @NotNull(message = "le champ ne doit pas etre null")
    @NotEmpty(message = "le champ ne doit pas etre vide")
    private String nomDuChampionnat;
    @NotBlank(message = "le champ ne doit pas etre blank")
    @NotNull(message = "le champ ne doit pas etre null")
    @NotEmpty(message = "le champ ne doit pas etre vide")
    @Pattern(regexp = "^\\d{4}-\\d{4}$", message = "la saison doit etre de la facon suivant num-num exemple : (2023-2024)")
    private String saison;
    @NotBlank(message = "le champ ne doit pas etre blank")
    @NotNull(message = "le champ ne doit pas etre null")
    @NotEmpty(message = "le champ ne doit pas etre vide")
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "la date doit suivre le format suivant jj-mm-aa")
    private String dateDebutChampionnat;
    @NotBlank(message = "le champ ne doit pas etre blank")
    @NotNull(message = "le champ ne doit pas etre null")
    @NotEmpty(message = "le champ ne doit pas etre vide")
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "la date doit suivre le format suivant jj-mm-aa")
    private String dateFinChampionnat;
    private TypeChampionnat typeChampionnat;
//    private List<EquipeDto> equipes;
}
