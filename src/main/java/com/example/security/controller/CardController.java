package com.example.security.controller;

import com.example.security.domain.model.Card;
import com.example.security.domain.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/cards/{cardId}")
    public List<Card> getCards(@PathVariable("cardId") Long cardId){
        return cardService.findByUserId(cardId);
    }
}
