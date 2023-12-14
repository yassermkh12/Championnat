package com.example.championnat.repositories;

import com.example.championnat.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEquipeRepository extends JpaRepository<Equipe,Long> {
}
