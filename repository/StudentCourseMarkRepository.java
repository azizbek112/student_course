package com.example.lesson_72.repository;

import com.example.lesson_72.entity.StudentCourseMarkEntity;
import com.example.lesson_72.mapper.StudentMapper;
import jakarta.persistence.criteria.CriteriaBuilder;
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

//    @Query("select StudentCourseMarkEntity.mark from StudentCourseMarkEntity where created_date =:date")
//    List<Integer> getMarkByDate(@Param("date") LocalDateTime date);

//    @Query("select StudentCourseMarkEntity.mark from StudentCourseMarkEntity where created_date>:date1 and created_date<:date2")
//    List<Integer> getBetweenDays(@Param("date1") LocalDateTime date1,@Param("date2") LocalDateTime date2);
    @Query("select mark from StudentCourseMarkEntity order by created_date desc ")
    List<Integer> getMarkLst();
    @Query("select mark from StudentCourseMarkEntity where course.id=:id order by created_date desc ")
    List<Integer> getListMark(@Param("id") Integer id);
    @Query(value = "select new com.example.lesson_72.mapper.StudentMapper(mark,course.name) from StudentCourseMarkEntity  where course.id=:id  order by created_date desc LIMIT 1",nativeQuery = true)
    StudentMapper getMarksById(@Param("id") Integer id);
    @Query(value = "select mark from StudentCourseMarkEntity order by mark asc limit 3",nativeQuery = true)
    List<Integer> mark3List();

    @Query(value = "select mark from StudentCourseMarkEntity order by created_date limit 1",nativeQuery = true)
    Integer getFirstMark();
    @Query(value = "select mark from StudentCourseMarkEntity where course.id=:id order by created_date limit 1",nativeQuery = true)
    Integer getFirstCourseMark(@Param("id") Integer id);
}
