package org.example.service.impl;

import org.example.models.NewEntryDateRequest;
import org.example.models.NewEntryDateResponse;
import org.example.repo.NewEntryDateRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NewEntryDateServiceImplTest {

    @Mock
    private NewEntryDateRepo newEntryDateRepo;

    @InjectMocks
    private NewEntryDateServiceImpl newEntryDateService;


//    @BeforeEach
//    void init() {
//        newEntryDateRequest = new NewEntryDateRequest();
//        newEntryDateRequest.setEntryDate(LocalDate.of(2025,2,23));
//        newEntryDateService = new NewEntryDateServiceImpl();
//    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(NewEntryDateServiceImplTest.class); // ✅ Force Mockito to inject mocks
    }

    @Test
    void createNewEntryDateRequest() {
        // Arrange
        NewEntryDateRequest request = new NewEntryDateRequest();
        request.setEntryDate(LocalDate.of(2025, 2, 24));

        NewEntryDateResponse response = new NewEntryDateResponse();
        response.setMessage("The date 2025-02-24 has been entered");

        // Act
        NewEntryDateResponse savedResponse = newEntryDateService.createNewEntryDate(request);

        // ✅ Verify that save() was called once
        verify(newEntryDateRepo, times(1)).save(any(NewEntryDateRequest.class));

        // ✅ Assertions
        assertNotNull(savedResponse);

        assertEquals("The date 2025-02-24 has been entered", savedResponse.getMessage());
    }

    @Test
    void createNewEntryDateRequestThrowsException() {
        // Arrange
        NewEntryDateRequest request = new NewEntryDateRequest();
        request.setEntryDate(LocalDate.of(2025, 2, 24));

        NewEntryDateResponse response = new NewEntryDateResponse();
        response.setMessage("The date 2025-02-24 has been entered");

        when(newEntryDateRepo.save(any())).thenThrow(RuntimeException.class);

        // Act
        NewEntryDateResponse savedResponse = newEntryDateService.createNewEntryDate(request);


        assertEquals("An error occurred while creating new entry date null", savedResponse.getMessage());

    }
}