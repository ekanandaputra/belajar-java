package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Tutorial;
import com.example.demo.repository.TutorialRepository;

public class TutorialControllerTest {

    @Mock
    private TutorialRepository tutorialRepository;

    @InjectMocks
    private TutorialController tutorialController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllTutorials_NoTitleProvided() {
        // Arrange - Given
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial("Tutorial 1", "Description 1", false));
        tutorials.add(new Tutorial("Tutorial 2", "Description 2", true));
        when(tutorialRepository.findAll()).thenReturn(tutorials);

        // Act - When
        ResponseEntity<List<Tutorial>> response = tutorialController.getAllTutorials(null);

        // Assert - Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tutorials, response.getBody());
    }

    @Test
    void testGetAllTutorials_NoContent() {
        // Arrange
        when(tutorialRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<List<Tutorial>> response = tutorialController.getAllTutorials(null);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testGetAllTutorials_InternalServerError() {
        // Arrange
        when(tutorialRepository.findAll()).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<List<Tutorial>> response = tutorialController.getAllTutorials(null);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testCreateTutorial_Success() {
        // Arrange
        Tutorial tutorial = new Tutorial("Title", "Description", false);
        when(tutorialRepository.save(tutorial)).thenReturn(1);

        // Act
        ResponseEntity<String> response = tutorialController.createTutorial(tutorial);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Tutorial was created successfully.", response.getBody());
    }

}
