package com.example.lesson_72.repository;

import com.example.lesson_72.entity.StudentCourseMarkEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentCourseMarkRepository extends CrudRepository<StudentCourseMarkEntity,Integer> {
    @Transactional
    @Modifying
    @Query("update StudentCourseMarkEntity set visible=:visible where id=:id")
    Integer deleteById2(@Param("visible") Boolean visible,@Param("id") Integer id);

    @Query("select StudentCourseMarkEntity.mark from StudentCourseMarkEntity where created_date =:date")
    List<Integer> getMarkByDate(@Param("date") LocalDateTime date);

    @Query("select StudentCourseMarkEntity.mark from StudentCourseMarkEntity where created_date>:date1 and created_date<:date2")
    List<Integer> getBetweenDays(@Param("date1") LocalDateTime date1,@Param("date2") LocalDateTime date2);
}
