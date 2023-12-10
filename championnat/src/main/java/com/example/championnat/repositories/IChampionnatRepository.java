package com.example.championnat.repositories;

import com.example.championnat.entities.Championnat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChampionnatRepository extends JpaRepository<Championnat,Long> {
}
