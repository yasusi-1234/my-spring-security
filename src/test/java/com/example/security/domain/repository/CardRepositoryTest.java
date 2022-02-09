package com.example.security.domain.repository;

import com.example.security.domain.model.Card;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Nested
    class FindByUserIdTest {
        @Test
        void appUserIdOf1 () throws Exception {
            List<Card> actual = cardRepository.findByAppUserId(1L);
            int expectedSize = 7;

            assertEquals(expectedSize, actual.size());

            long expectedUserIdSize = 1L;
            long actualCount = actual.stream().map(Card::getAppUserId).distinct().count();

            assertEquals(expectedUserIdSize, actualCount);
        }

        @Test
        void appUserIdOf2 () throws Exception {
            List<Card> actual = cardRepository.findByAppUserId(2L);
            int expectedSize = 5;

            assertEquals(expectedSize, actual.size());

            long expectedUserIdSize = 1L;
            long actualCount = actual.stream().map(Card::getAppUserId).distinct().count();

            assertEquals(expectedUserIdSize, actualCount);
        }

        @Test
        void appUserIdOf3 () throws Exception {
            List<Card> actual = cardRepository.findByAppUserId(3L);
            int expectedSize = 8;

            assertEquals(expectedSize, actual.size());

            long expectedUserIdSize = 1L;
            long actualCount = actual.stream().map(Card::getAppUserId).distinct().count();

            assertEquals(expectedUserIdSize, actualCount);
        }

    }
}