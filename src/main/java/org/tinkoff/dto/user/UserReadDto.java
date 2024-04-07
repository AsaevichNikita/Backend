package org.tinkoff.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tinkoff.database.entity.UserRoleDto;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto to read user entity.")
public class UserReadDto {

    @Schema(description = "User birthday", example = "2002-01-01")
    LocalDate birthday;
    @Schema(description = "User email", example = "example@mail.ru")
    @NotBlank(message = "User email can't be blank")
    String email;
    @Schema(description = "User full name", example = "John Doe")
    @NotBlank(message = "User full name can't be blank")
    String fullName;
    @Schema(description = "User role", example = "MENTOR")
    UserRoleDto userRoleDto;
}
