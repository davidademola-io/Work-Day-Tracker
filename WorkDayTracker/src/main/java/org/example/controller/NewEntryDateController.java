package org.example.controller;

import jakarta.validation.Valid;
import org.example.models.FindExpiredDatesResponse;
import org.example.models.NewEntryDateRequest;
import org.example.models.NewEntryDateResponse;
import org.example.service.FindExpiredDates;
import org.example.service.NewEntryDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class NewEntryDateController {

    Logger logger = LoggerFactory.getLogger(NewEntryDateController.class);

    @Autowired
    NewEntryDate newEntryDate;

    @Autowired
    FindExpiredDates findExpiredDates;

    NewEntryDateResponse newEntryDateResponse = new NewEntryDateResponse();
    FindExpiredDatesResponse findExpiredDatesResponse = new FindExpiredDatesResponse();


    @PostMapping("/newEntryDate")
    public NewEntryDateResponse enterDate(@Valid @RequestBody NewEntryDateRequest newEntryDateRequest) {
        logger.info("received request: {}", newEntryDateRequest);
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

    @PostMapping("/findExpiredDates")
    public Object upcomingExpiredDates() {

        LocalDate now = LocalDate.now();
        LocalDate end = LocalDate.now().plusDays(14);
        logger.info("checking for upcoming expired dates for the next 2 weeks starting from: {}", now);

        try {
            findExpiredDatesResponse = findExpiredDates.findUpcomingExpiredDates(now,end);
            logger.info("request processed");

            return findExpiredDatesResponse;
        }
        catch (Exception e) {
            logger.info("exception occurred");
            return findExpiredDates;
        }
    }
}