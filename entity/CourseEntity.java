package com.example.lesson_72.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "course")
public class CourseEntity {
    //id,name,price,duration,createdDate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer duration;
    private LocalDate created_date=LocalDate.now();
}
