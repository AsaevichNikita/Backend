package org.tinkoff.dto.keycloak;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tinkoff.database.entity.UserRoleDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto to registration")
public class UserRegisterDto {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String userRoleDto;
}