package com.ucd.ecs235.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String name;

    @Column(nullable = false)
    private Level level;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    List<CourseRegistration> registrations;

    @ManyToOne
    private User lecturer;
}