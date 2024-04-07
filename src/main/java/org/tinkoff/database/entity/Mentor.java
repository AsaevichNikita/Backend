package org.tinkoff.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mentor")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorId;
    @Column(nullable = false)
    @NotEmpty(message = "Experience should not be empty")
    private String experience;

    @Column(nullable = false)
    @NotEmpty(message = "How you help should not be empty")
    private String howCanHelp;

    @Column(nullable = false)
    @NotEmpty(message = "Skills should not be empty")
    private String skills;

    @Column(nullable = false)
    private Integer tagId;

    @Column(nullable = false)
    private Integer userId;

    @Builder.Default
    @OneToMany(mappedBy = "mentor")
    private List<MentorHasCatalogProfessions> mentorHasCatalogProfessions = new ArrayList<>();

}
