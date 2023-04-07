package com.example.lesson_72.repository;

import com.example.lesson_72.entity.StudentCourseMarkEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseMarkRepository extends CrudRepository<StudentCourseMarkEntity,Integer> {
}
