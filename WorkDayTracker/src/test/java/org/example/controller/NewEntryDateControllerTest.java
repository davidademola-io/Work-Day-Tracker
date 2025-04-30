package org.example.controller;

import org.example.models.NewEntryDateRequest;
import org.example.models.NewEntryDateResponse;
import org.example.service.NewEntryDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class NewEntryDateControllerTest {

    @InjectMocks
    private NewEntryDateController entryDateController;

    @Mock
    private NewEntryDate newEntryDate;

    private NewEntryDateRequest request;
    private NewEntryDateResponse successResponse;

    @BeforeEach
    void setUp() {
        request = new NewEntryDateRequest();
        request.setEntryDate(LocalDate.of(2025, 4, 30));

        successResponse = new NewEntryDateResponse();
        successResponse.setMessage("Success");
    }

    @Test
    void testEnterDate_Success() {
        Mockito.when(newEntryDate.createNewEntryDate(Mockito.any())).thenReturn(successResponse);

        NewEntryDateResponse actual = entryDateController.enterDate(request);

        assertEquals("Success", actual.getMessage());
    }

    @Test
    void testEnterDate_Exception() {
        Mockito.when(newEntryDate.createNewEntryDate(Mockito.any()))
                .thenThrow(new RuntimeException("Something went wrong"));

        NewEntryDateResponse actual = entryDateController.enterDate(request);

        assertEquals("Something went wrong", actual.getMessage());
    }
}