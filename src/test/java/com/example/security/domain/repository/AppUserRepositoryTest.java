package com.example.security.domain.repository;

import com.example.security.domain.model.AppUser;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void findAllUserTest() throws Exception {
        List<AppUser> actual = appUserRepository.findAll();
        int expectedSize = 3;

        assertEquals(expectedSize, actual.size());
    }

    @Nested
    class FindByIdTest {
        @Test
        public void findById1Test() throws Exception {
            AppUser actual = appUserRepository.findById(1L).orElse(new AppUser());

            String expectedName = "Alice";

            assertEquals(expectedName, actual.getName());

            int expectedRoleSize = 3;

            assertEquals(expectedRoleSize, actual.getRoles().size());
        }

        @Test
        public void findById2Test() throws Exception{
            AppUser actual = appUserRepository.findById(2L).orElse(new AppUser());

            String expectedName = "Bob";

            assertEquals(expectedName, actual.getName());

            int expectedRoleSize = 2;

            assertEquals(expectedRoleSize, actual.getRoles().size());
        }
    }

    @Nested
    class FindByMailAddressTest {

        @Test
        void findByMailAddressOfAlice() {
            AppUser actual = appUserRepository.findByMailAddress("alice@example.com");

            String expected = "Alice";

            assertEquals(expected, actual.getName());
        }

        @Test
        void findByMailAddressOfNotExist() {
            AppUser actual = appUserRepository.findByMailAddress("nouser@example.com");

            assertNull(actual);
        }

    }
}