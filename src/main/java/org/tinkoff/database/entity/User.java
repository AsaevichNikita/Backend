package org.tinkoff.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    @NotEmpty(message = "E-mail should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Column(nullable = false)
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 50, message = "Name should be short")
    private String fullName;

    @Column(nullable = false)
    @NotEmpty(message = "Password should not be empty")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoleDto userRoleDto;
}
