package ie.atu.cicd_week5.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {
    @NotBlank @Size(max = 40) //maximum characters is 40 and cannot be left blank
    private String passengerId;

    @NotBlank @Size(max = 40)
    private String name;

    @NotBlank @Email //must be a correct email format
    private String email;


}
