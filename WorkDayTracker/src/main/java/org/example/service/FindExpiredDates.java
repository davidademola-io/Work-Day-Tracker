package org.example.service;
import org.example.models.FindExpiredDatesResponse;
import org.example.models.NewEntryDateRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface FindExpiredDates {

    FindExpiredDatesResponse findUpcomingExpiredDates(LocalDate start, LocalDate end);

}
