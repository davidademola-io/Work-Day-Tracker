package org.example.controller;

import org.example.models.NewEntryDateRequest;
import org.example.models.NewEntryDateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewEntryDateController {

    Logger logger = LoggerFactory.getLogger(NewEntryDateController.class);

    @PostMapping("/newEntryDate")
    public NewEntryDateResponse enterDate(NewEntryDateRequest newEntryDateRequest) {
        logger.info("received request");
        logger.info("request processed");
        return new NewEntryDateResponse();
    }
}
