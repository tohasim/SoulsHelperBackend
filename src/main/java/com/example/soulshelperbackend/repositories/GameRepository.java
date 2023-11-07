package com.example.soulshelperbackend.repositories;

import com.example.soulshelperbackend.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
