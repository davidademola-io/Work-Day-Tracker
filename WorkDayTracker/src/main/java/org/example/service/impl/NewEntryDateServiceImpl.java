package org.example.service.impl;

import org.example.models.NewEntryDateRequest;
import org.example.models.NewEntryDateResponse;
import org.example.service.NewEntryDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class NewEntryDateServiceImpl implements NewEntryDate {

    Logger logger = LoggerFactory.getLogger(NewEntryDateServiceImpl.class);

    NewEntryDateResponse newEntryDateResponse = new NewEntryDateResponse();

    @Override
    public NewEntryDateResponse createNewEntryDate(NewEntryDateRequest newEntryDateRequest) {
        logger.info("Processing new entry date request");
        newEntryDateRequest.setExpiryDate(newEntryDateRequest.getEntryDate().plusDays(90));
        newEntryDateResponse.setMessage("The date " + newEntryDateRequest.getEntryDate().toString() + " has been entered");
        return newEntryDateResponse;
    }
}
