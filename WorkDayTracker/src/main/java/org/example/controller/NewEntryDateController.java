package org.example.controller;

import jakarta.validation.Valid;
import org.example.models.NewEntryDateRequest;
import org.example.models.NewEntryDateResponse;
import org.example.service.NewEntryDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewEntryDateController {

    Logger logger = LoggerFactory.getLogger(NewEntryDateController.class);

    @Autowired
    NewEntryDate newEntryDate;

    NewEntryDateResponse newEntryDateResponse = new NewEntryDateResponse();

    @PostMapping("/newEntryDate")
    public NewEntryDateResponse enterDate(@Valid @RequestBody NewEntryDateRequest newEntryDateRequest) {
        logger.info("received request");
        try {
            newEntryDateResponse = newEntryDate.createNewEntryDate(newEntryDateRequest);
            logger.info("request processed");
        }
        catch (Exception e) {
            logger.info("exception occurred");
            newEntryDateResponse.setMessage(e.getMessage());
            return newEntryDateResponse;
        }
        return newEntryDateResponse;
    }
}
