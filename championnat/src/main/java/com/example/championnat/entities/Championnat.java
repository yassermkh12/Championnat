package com.example.championnat.entities;

import com.example.championnat.entities.enums.TypeChampionnat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "championnat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Championnat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomDuChampionnat;
    private String saison;
    private String dateDebutChampionnat;
    private String dateFinChampionnat;
//    liste des equipe
    //classemet
    //calendrier des match
    @Enumerated(EnumType.STRING)
    private TypeChampionnat typeChampionnat;
}
