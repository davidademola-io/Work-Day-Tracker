package org.example.models;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewEntryDateResponse {

    private String message;
}
