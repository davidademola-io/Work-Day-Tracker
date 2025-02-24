package org.example.service;

import org.example.models.NewEntryDateRequest;
import org.example.models.NewEntryDateResponse;
import org.springframework.stereotype.Service;

@Service
public interface NewEntryDate {

    public NewEntryDateResponse createNewEntryDate(NewEntryDateRequest newEntryDateRequest);
}
