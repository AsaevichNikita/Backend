package org.tinkoff.dto.catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto to read catalog professions entity.")
public class CatalogProfessionsReadDto {
    @Schema(description = "Name of catalog professions", example = "C++")
    @NotBlank(message = "Name of catalog professions can't be blank")
    String name;
}
