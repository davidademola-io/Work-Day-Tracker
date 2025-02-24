package org.example.service;

import org.example.models.NewEntryDateRequest;
import org.example.models.NewEntryDateResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface NewEntryDate {

    public NewEntryDateResponse createNewEntryDate(NewEntryDateRequest newEntryDateRequest);

    public List<LocalDate> getExpiryDates();
}
