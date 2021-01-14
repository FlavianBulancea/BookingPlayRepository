package com.example.app.repository;

import com.example.app.model.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {
}
