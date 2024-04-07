package org.tinkoff.dto.mentor;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto to read mentor entity.")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MentorReadDto {

    @Schema(description = "Mentor experience", example = "Java 2 y.o experience")
    @NotBlank(message = "Mentor experience can't be blank")
    String experience;
    @Schema(description = "How mentor can help to you", example = "I can help learn Java Core")
    @NotBlank(message = "Mentor help description can't be blank")
    String howCanHelp;
    @Schema(description = "Mentor skills", example = "Docker, Spring, JUnit, etc.")
    @NotBlank(message = "Mentor skills can't be blank")
    String skills;
}
