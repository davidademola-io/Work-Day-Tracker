package org.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entry_date",schema = "track")
public class NewEntryDateRequest implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private Long id;

    @NotNull
    private LocalDate entryDate;

    private LocalDate expiryDate;

}
