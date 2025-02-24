package org.example.service.impl;

import org.example.models.NewEntryDateRequest;
import org.example.models.NewEntryDateResponse;
import org.example.repo.NewEntryDateRepo;
import org.example.service.NewEntryDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewEntryDateServiceImpl implements NewEntryDate {

    @Autowired
    NewEntryDateRepo newEntryDateRepo;

    Logger logger = LoggerFactory.getLogger(NewEntryDateServiceImpl.class);

    NewEntryDateResponse newEntryDateResponse = new NewEntryDateResponse();

    @Override
    public NewEntryDateResponse createNewEntryDate(NewEntryDateRequest newEntryDateRequest) {
        try {
            logger.info("Processing new entry date request");
            newEntryDateRequest.setExpiryDate(newEntryDateRequest.getEntryDate().plusDays(90));
            newEntryDateResponse.setMessage("The date " + newEntryDateRequest.getEntryDate().toString() + " has been entered");
            newEntryDateRepo.save(newEntryDateRequest);
            logger.info("New entry date was created");
            return newEntryDateResponse;
        }
        catch (Exception e) {

            newEntryDateResponse.setMessage("An error occurred while creating new entry date " + e.getMessage());
            return newEntryDateResponse;
        }
    }
}
