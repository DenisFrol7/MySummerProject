package com.example.mysummerproject.repository;

import com.example.mysummerproject.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
