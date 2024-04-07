package org.tinkoff.dto.mentor_catalog;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.tinkoff.dto.catalog.CatalogProfessionsReadDto;
import org.tinkoff.dto.mentor.MentorReadDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto to read mentor catalog professions link entity.")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MentorHasCatalogProfessionsReadDto {

    CatalogProfessionsReadDto catalogProfessionsReadDto;
    MentorReadDto mentorReadDto;
}
