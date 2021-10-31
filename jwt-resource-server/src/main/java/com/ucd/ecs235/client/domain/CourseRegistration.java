package com.ucd.ecs235.client.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Course course;

    LocalDateTime registeredAt;

    int grade;

    @PrePersist
    private void onSave() {
        this.registeredAt = LocalDateTime.now();
    }
}