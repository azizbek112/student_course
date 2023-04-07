package com.example.lesson_72.repository;

import com.example.lesson_72.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity,Integer> {
    List<CourseEntity> getCourseEntitiesByName(String name);
    List<CourseEntity> getCourseEntitiesByPrice(Double price);
    List<CourseEntity> getCourseEntitiesByDuration(Integer duration);
    List<CourseEntity> getCourseEntitiesByDurationBetween(Integer duration1,Integer duration2);

}
