package com.example.lesson_72.dto;

import com.example.lesson_72.enums.StudentRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class StudentDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer level;
    private Integer age;
    private StudentRole gender;
}
