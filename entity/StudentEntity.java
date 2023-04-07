package com.example.lesson_72.entity;

import com.example.lesson_72.enums.StudentRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Integer level;
    @Enumerated(value = EnumType.STRING)
    private StudentRole gender;
    private Integer age;
    private LocalDate created_dat=LocalDate.now();
    private Boolean visible;

    public StudentEntity(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
