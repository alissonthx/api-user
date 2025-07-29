package com.alissondev.api_user.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "name")
    private String name;
}
