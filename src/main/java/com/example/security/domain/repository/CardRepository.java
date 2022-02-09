package com.example.security.domain.repository;

import com.example.security.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByAppUserId(long userId);
}