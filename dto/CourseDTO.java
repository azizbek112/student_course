package com.example.lesson_72.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CourseDTO {
    //id,name,price,duration,createdDate
    private Integer id;
    private String name;
    private Double price;
    private Integer duration;
    private LocalDate created_date;
}
