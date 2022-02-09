package com.example.security.domain.service;

import com.example.security.domain.model.Card;

import java.util.List;

public interface CardService {
    List<Card> findByUserId(Long userId);
}
