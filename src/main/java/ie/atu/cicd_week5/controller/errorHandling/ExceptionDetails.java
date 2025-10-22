package ie.atu.cicd_week5.controller.errorHandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails {
    private String FieldName;
    private String FieldValue;
}
