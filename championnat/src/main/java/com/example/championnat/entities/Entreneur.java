package com.example.championnat.entities;

import com.example.championnat.entities.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "entreneur")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entreneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String nationalite;
    private String numeroDeTelephone;
    private String adresseEmail;
    //relation experience entreneur
    //realation certification entreneur
    private String dateDebutContrat;
    private String contrat;
}
