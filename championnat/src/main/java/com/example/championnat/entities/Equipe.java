package com.example.championnat.entities;

import com.example.championnat.entities.enums.StatusEquipe;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "equipe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Long budgetEquipe;
    @Enumerated(value = EnumType.STRING)
    private StatusEquipe statusEquipe;
    //relation championnat
    @ManyToOne
    private Championnat championnat;
}
