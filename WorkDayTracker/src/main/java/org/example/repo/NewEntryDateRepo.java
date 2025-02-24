package org.example.repo;

import org.example.models.NewEntryDateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewEntryDateRepo extends JpaRepository<NewEntryDateRequest,Long> {

}
