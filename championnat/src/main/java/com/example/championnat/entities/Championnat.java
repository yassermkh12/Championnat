package com.example.championnat.entities;

import com.example.championnat.entities.enums.TypeChampionnat;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "championnat")
@Getter
@Setter
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
    @OneToMany(mappedBy = "championnat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Equipe> equipes;
}
