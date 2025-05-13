package com.mbcjava2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_seq_generator")
    @SequenceGenerator(name = "actor_seq_generator", sequenceName = "SEQ_TBL_ACTOR", allocationSize = 1)
    private Long actorId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 10)
    private String gender;

    private LocalDate birthday;
}

