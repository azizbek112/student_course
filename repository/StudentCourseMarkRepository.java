package com.example.lesson_72.repository;

import com.example.lesson_72.entity.StudentCourseMarkEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentCourseMarkRepository extends CrudRepository<StudentCourseMarkEntity,Integer> {
    @Query("update StudentCourseMarkEntity set visible=:visible where id=:id")
    Integer deleteById2(@Param("visible") Boolean visible,@Param("id") Integer id);

    @Query("select StudentCourseMarkEntity.mark from StudentCourseMarkEntity where created_date=:date")
    List<Integer> getMarkByDate(@Param("date")LocalDate date);
}
