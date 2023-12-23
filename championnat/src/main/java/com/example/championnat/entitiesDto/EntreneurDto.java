package com.example.championnat.entitiesDto;

import com.example.championnat.entities.enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntreneurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private Genre genre;
    private String nationalite;
    private String numeroDeTelephone;
    private String adresseEmail;
    //relation experience entreneur
    //realation certification entreneur
    private String dateDebutContrat;
    private String contrat;
}
