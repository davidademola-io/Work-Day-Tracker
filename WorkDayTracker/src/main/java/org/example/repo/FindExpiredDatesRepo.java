package org.example.repo;

import org.example.models.FindExpiredDatesResponse;
import org.example.models.NewEntryDateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FindExpiredDatesRepo extends JpaRepository<NewEntryDateRequest, Long> {

    List<NewEntryDateRequest> findByexpiryDateBetween(LocalDate expiryDate, LocalDate expiryDate2);

}
