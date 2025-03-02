package org.example.service.impl;

import org.example.models.NewEntryDateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NewEntryDateServiceImplTest {

    NewEntryDateRequest newEntryDateRequest;

    NewEntryDateServiceImpl newEntryDateService;

    @BeforeEach
    void init() {
        newEntryDateRequest = new NewEntryDateRequest();
        newEntryDateRequest.setEntryDate(LocalDate.of(2025,2,23));
        newEntryDateService = new NewEntryDateServiceImpl();
    }

    @Test
    void createNewEntryDateReqyest() {
        assertNotNull(newEntryDateRequest);
        assertNotNull(newEntryDateRequest.getEntryDate());
        assertEquals(LocalDate.of(2025,2,23), newEntryDateRequest.getEntryDate());
        //assertEquals(LocalDate.of(2025,5,4),newEntryDateRequest.getExpiryDate());
    }

    @Test
    void testExpiryDateIsValid() {
        newEntryDateService.createNewEntryDate(newEntryDateRequest);
        assertNotNull(newEntryDateRequest.getEntryDate());
        assertEquals(LocalDate.of(2025,5,24), newEntryDateRequest.getExpiryDate());

    }
}