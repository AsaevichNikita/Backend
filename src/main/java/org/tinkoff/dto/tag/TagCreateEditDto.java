package org.tinkoff.dto.tag;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto to create and edit tag entity.")
public class TagCreateEditDto {

    @Schema(description = "Tag name", example = "Soft Skills")
    @NotBlank(message = "Tag name can't be blank")
    String tag;
}
