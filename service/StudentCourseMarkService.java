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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
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
        StudentEntity studentEntity = studentService.get(studentCourseMarkDTO.getStudent().getId());
        CourseEntity courseEntity = courseService.get(studentCourseMarkDTO.getCourse().getId());
        StudentCourseMarkEntity studentCourseMark=new StudentCourseMarkEntity();
        studentCourseMark.setCourse(courseEntity);
        studentCourseMark.setStudent(studentEntity);
        studentCourseMark.setMark(studentCourseMarkDTO.getMark());
        studentCourseMark.setCreated_date(LocalDateTime.now());
        repository.save(studentCourseMark);
        studentCourseMarkDTO.setId(studentCourseMark.getId());
        return studentCourseMarkDTO;
    }

    public StudentCourseMarkDTO getById(Integer id) {
        StudentCourseMarkEntity entity = get(id);
        StudentCourseMarkDTO studentCourseMarkDTO=new StudentCourseMarkDTO();
        studentCourseMarkDTO.setCourse(entity.getCourse());
        studentCourseMarkDTO.setMark(entity.getMark());
        studentCourseMarkDTO.setStudent(entity.getStudent());
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
        StudentEntity studentEntity = studentService.get(dto.getStudent().getId());
        CourseEntity courseEntity = courseService.get(dto.getCourse().getId());
        StudentCourseMarkEntity entity=new StudentCourseMarkEntity();
        entity.setCourse(courseEntity);
        entity.setStudent(studentEntity);
        entity.setMark(dto.getMark());
        repository.save(entity);
        repository.delete(studentCourseMark);
        return true;
    }

    public Boolean deleteById(Integer id) {
        StudentCourseMarkEntity entity = get(id);
        Integer integer = repository.deleteById2(false, id);

        if (integer ==1){
            return true;
        }else {
            return false;
        }
    }

    public List<Integer> getDaysMark(LocalDate date) {
//        List<Integer> markByDate = repository.getMarkByDate(LocalDateTime.of(date,LocalTime.MIN));
//        return markByDate;
        return null;
    }

    public List<Integer> getBetween(LocalDate date1, LocalDate date2) {
//        List<Integer> betweenDays = repository.getBetweenDays(LocalDateTime.of(date1, LocalTime.MIN), LocalDateTime.of(date2, LocalTime.MAX));
//        return betweenDays;
        return null;
    }

    public List<Integer> getListMarks() {
        List<Integer> markLst = repository.getMarkLst();
        return markLst;
    }

    public List<Integer> getMarkListById(Integer id) {
        List<Integer> listMark = repository.getListMark(id);
        return listMark;
    }

    public List<Integer> getMark3List() {
        List<Integer> integers = repository.mark3List();
        return integers;
    }
    public Integer getMark1List() {
        Integer firstMark = repository.getFirstMark();
        return firstMark;
    }

    public Object getCourseMarkList(Integer id) {
        Integer firstCourseMark = repository.getFirstCourseMark(id);
        return firstCourseMark;
    }

    public Integer getHighlyMark(Integer id) {
        Integer highlyMark = repository.getHighlyMark(id);
        return highlyMark;
    }

    public Object getAvgCourseMark(Integer id) {
        Integer avgCourseMark = repository.getAvgCourseMark(id);
        return avgCourseMark;
    }

    public Integer getCountsCourseMark(Integer id) {
        Integer countsCourseMark = repository.getCountsCourseMark(id);
        return countsCourseMark;
    }
}
