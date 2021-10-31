package com.ucd.ecs235.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "school_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String userName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<CourseRegistration> registrations;

    @OneToMany(mappedBy = "lecturer")
    @JsonIgnore
    private List<Course> teachingCourses;
}
