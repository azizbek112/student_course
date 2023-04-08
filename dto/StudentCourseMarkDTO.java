package com.example.lesson_72.dto;

import com.example.lesson_72.entity.CourseEntity;
import com.example.lesson_72.entity.StudentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourseMarkDTO {
    private Integer id;
    private StudentEntity student;
    private CourseEntity course;
    private Integer mark;
    private Boolean visible;
}
