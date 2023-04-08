package com.example.lesson_72.mapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentMapper {
    private Integer mark;
    private String name;

    public StudentMapper(Integer mark, String name) {
        this.mark = mark;
        this.name = name;
    }
}
