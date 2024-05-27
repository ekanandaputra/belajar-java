package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Tutorial;

@SpringBootTest
public class JdbcTutorialRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JdbcTutorialRepository tutorialRepository;

    @Test
    public void testSave() {
        Tutorial tutorial = new Tutorial("Sample Title", "Sample Description", true);
        int result = tutorialRepository.save(tutorial);
        
        assertEquals(1, result);
    }

    @Test
    void testDeleteAll() {

    }

    @Test
    void testDeleteById() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindByPublished() {

    }

    @Test
    void testFindByTitleContaining() {

    }

    @Test
    void testUpdate() {

    }
}
