package com.example.championnat.entitiesDto;

import com.example.championnat.entities.enums.TypeChampionnat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampionnatDto {
    private Long id;
    private String nomDuChampionnat;
    private String saison;
    private String dateDebutChampionnat;
    private String dateFinChampionnat;
    private TypeChampionnat typeChampionnat;
}
