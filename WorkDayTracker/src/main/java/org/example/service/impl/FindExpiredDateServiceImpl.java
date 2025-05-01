package org.example.service.impl;

import org.example.models.FindExpiredDatesResponse;
import org.example.models.NewEntryDateRequest;
import org.example.repo.FindExpiredDatesRepo;
import org.example.service.FindExpiredDates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FindExpiredDateServiceImpl implements FindExpiredDates {

    Logger logger = LoggerFactory.getLogger(FindExpiredDateServiceImpl.class);

    @Autowired
    FindExpiredDatesRepo findExpiredDatesRepo;

    FindExpiredDatesResponse findExpiredDatesResponse = new FindExpiredDatesResponse();

    @Override
    public FindExpiredDatesResponse findUpcomingExpiredDates(LocalDate start, LocalDate end) {
        List<LocalDate> listOfExpiredDates = new ArrayList<>();

        try {
            logger.info("Checking database for records");
            List<NewEntryDateRequest> findExpired = findExpiredDatesRepo.findByexpiryDateBetween(start, end);
            FindExpiredDatesResponse expiredDatesResponse = new FindExpiredDatesResponse();

            for (NewEntryDateRequest newEntryDateRequest : findExpired) {
                listOfExpiredDates.add(newEntryDateRequest.getExpiryDate());
            }

            expiredDatesResponse.setExpiredDates(listOfExpiredDates);

            return expiredDatesResponse;

        }catch (Exception e){
            e.printStackTrace();
        }
        return findExpiredDatesResponse;
    }
}
