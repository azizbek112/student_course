package com.example.lesson_72.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourseMarkDTO {
    private Integer id;
    private Integer student_id;
    private Integer course_id;
    private Integer mark;
}
