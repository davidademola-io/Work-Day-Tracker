package org.example.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NewEntryDateRequest implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    Data entryDate;

}
