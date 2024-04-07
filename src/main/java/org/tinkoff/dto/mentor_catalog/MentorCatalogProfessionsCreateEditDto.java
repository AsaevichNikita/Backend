package org.tinkoff.dto.mentor_catalog;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto to create and edit mentor catalog professions link entity.")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MentorCatalogProfessionsCreateEditDto {

    @Schema(description = "Catalog profession Id", example = "1")
    @Positive(message = "Catalog profession Id can't be less than one")
    Integer catalogProfessionsId;
    @Schema(description = "mentor Id", example = "1")
    @Positive(message = "mentor Id can't be less than one")
    Integer mentorId;
}
