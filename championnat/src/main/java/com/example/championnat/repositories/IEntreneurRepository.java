package com.example.championnat.repositories;

import com.example.championnat.entities.Entreneur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEntreneurRepository extends JpaRepository<Entreneur,Long> {
}
