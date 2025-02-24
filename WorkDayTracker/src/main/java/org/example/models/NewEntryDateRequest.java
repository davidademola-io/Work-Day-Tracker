package org.example.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "entry_date",schema = "work_tracker")
public class NewEntryDateRequest implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDate entryDate;

    @Column(nullable = false)
    private LocalDate expiryDate;

}
