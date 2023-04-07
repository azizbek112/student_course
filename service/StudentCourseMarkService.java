package com.example.lesson_72.service;

import com.example.lesson_72.dto.StudentCourseMarkDTO;
import com.example.lesson_72.entity.CourseEntity;
import com.example.lesson_72.entity.StudentCourseMarkEntity;
import com.example.lesson_72.entity.StudentEntity;
import com.example.lesson_72.exp.AppBadRequestException;
import com.example.lesson_72.repository.StudentCourseMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class StudentCourseMarkService {
    @Autowired
    private StudentCourseMarkRepository repository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    public StudentCourseMarkDTO create(StudentCourseMarkDTO studentCourseMarkDTO) {
        StudentEntity studentEntity = studentService.get(studentCourseMarkDTO.getStudent_id());
        CourseEntity courseEntity = courseService.get(studentCourseMarkDTO.getCourse_id());
        StudentCourseMarkEntity studentCourseMark=new StudentCourseMarkEntity();
        studentCourseMark.setCourse(courseEntity);
        studentCourseMark.setStudent(studentEntity);
        studentCourseMark.setMark(studentCourseMarkDTO.getMark());
        studentCourseMark.setCreated_date(LocalDate.now());
        repository.save(studentCourseMark);
        studentCourseMarkDTO.setId(studentCourseMark.getId());
        return studentCourseMarkDTO;
    }

    public StudentCourseMarkDTO getById(Integer id) {
        StudentCourseMarkEntity entity = get(id);
        StudentCourseMarkDTO studentCourseMarkDTO=new StudentCourseMarkDTO();
        studentCourseMarkDTO.setCourse_id(entity.getCourse().getId());
        studentCourseMarkDTO.setMark(entity.getMark());
        studentCourseMarkDTO.setStudent_id(entity.getStudent().getId());
        studentCourseMarkDTO.setId(entity.getId());
        return studentCourseMarkDTO;
    }
    public StudentCourseMarkEntity get(Integer id){
        Optional<StudentCourseMarkEntity> entity = repository.findById(id);
        if (entity == null){
            throw new AppBadRequestException("StudentCourseMarkEntity is null");
        }
        return entity.get();
    }

    public Boolean update(Integer id, StudentCourseMarkDTO dto) {
        StudentCourseMarkEntity studentCourseMark = get(id);
        StudentEntity studentEntity = studentService.get(dto.getStudent_id());
        CourseEntity courseEntity = courseService.get(dto.getCourse_id());
        StudentCourseMarkEntity entity=new StudentCourseMarkEntity();
        entity.setCourse(courseEntity);
        entity.setStudent(studentEntity);
        entity.setMark(dto.getMark());
        repository.save(entity);
        repository.delete(studentCourseMark);
        return true;
    }
}
