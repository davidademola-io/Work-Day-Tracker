package org.example.service.impl;

import org.example.models.NewEntryDateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NewEntryDateServiceImplTest {

    NewEntryDateRequest newEntryDateRequest;

    @BeforeEach
    void setNewEntryDateRequest() {
        newEntryDateRequest = new NewEntryDateRequest();
        newEntryDateRequest.setEntryDate(LocalDate.ofEpochDay(2025-02-23));
    }

    @Test
    void createNewEntryDate() {
        assertNotNull(newEntryDateRequest);
    }
}