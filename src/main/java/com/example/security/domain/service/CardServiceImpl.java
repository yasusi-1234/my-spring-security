package com.example.security.domain.service;

import com.example.security.domain.model.Card;
import com.example.security.domain.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> findByUserId(Long userId) {
        return cardRepository.findByAppUserId(userId);
    }

//    public Card findByCardId(Long cardId) {
//
//    }
}
