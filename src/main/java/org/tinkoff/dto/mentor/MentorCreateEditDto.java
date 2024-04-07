package org.tinkoff.dto.mentor;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto to create and edit mentor entity.")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MentorCreateEditDto {

    @Schema(description = "Mentor experience", example = "Java 2 y.o experience")
    @NotBlank(message = "Mentor experience can't be blank")
    String experience;
    @Schema(description = "How mentor can help to you", example = "I can help learn Java Core")
    @NotBlank(message = "Mentor help description can't be blank")
    String howCanHelp;
    @Schema(description = "Mentor skills", example = "Docker, Spring, JUnit, etc.")
    @NotBlank(message = "Mentor skills can't be blank")
    String skills;
    @Schema(description = "Tag's Id", example = "1")
    @Positive(message = "Tag Id can't be less than one")
    Integer tagId;
    @Schema(description = "Name of catalog professions", example = "1")
    @Positive(message = "Name of catalog professions can't be blank")
    Integer userId;
}
