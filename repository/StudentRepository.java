package com.example.lesson_72.repository;

import com.example.lesson_72.entity.StudentEntity;
import com.example.lesson_72.enums.StudentRole;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {
    List<StudentEntity> getStudentEntitiesByName(String name);
    List<StudentEntity> getStudentEntitiesBySurname(String surname);
    List<StudentEntity> getStudentEntitiesByLevel(Integer level);
    List<StudentEntity> getStudentEntitiesByAge(Integer age);
    List<StudentEntity> getStudentEntitiesByGender(StudentRole role);
//    List<StudentEntity> getStudentEntitiesByCreated_date(LocalDate date);
//    List<StudentEntity> getStudentEntitiesByCreated_dateBetweenAndCreated_date(LocalDate date LocalDate time);
    @Transactional
    @Modifying
    @Query("update StudentEntity set visible=:visible where id=:sid")
    Integer changeVisibility(@Param("sid") Integer sid,@Param("visible") Boolean visible);

    @Query("FROM StudentEntity where name like ?1")
    List<StudentEntity> findByName2(String name);

    @Query("select new StudentEntity (id,name,surname) from StudentEntity ")
    List<StudentEntity> findByName3();
    List<StudentEntity> findAllByNameIn(List<String> phoneList);
}
