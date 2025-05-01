package org.example.models;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindExpiredDatesResponse {

    private List<LocalDate> expiredDates;

}
