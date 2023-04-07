package com.example.lesson_72.service;

import com.example.lesson_72.dto.CourseDTO;
import com.example.lesson_72.entity.CourseEntity;
import com.example.lesson_72.exp.AppBadRequestException;
import com.example.lesson_72.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseDTO create(CourseDTO courseDTO) {
        CourseEntity course=new CourseEntity();
        course.setName(courseDTO.getName());
        course.setDuration(courseDTO.getDuration());
        course.setPrice(courseDTO.getPrice());
        if (courseDTO.getName()==null || courseDTO.getName().isBlank()){
            throw new AppBadRequestException("Course name is null");
        }
        course.setCreated_date(LocalDate.now());
        courseRepository.save(course);
        courseDTO.setId(course.getId());
        return courseDTO;
    }

    public CourseDTO getById(Integer id) {
        CourseEntity course = get(id);
        CourseDTO courseDTO=new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDuration(course.getDuration());
        courseDTO.setCreated_date(course.getCreated_date());
        courseDTO.setDuration(course.getDuration());
        return courseDTO;
    }
    public CourseEntity get(Integer id){
        Optional<CourseEntity> byId = courseRepository.findById(id);
        if (byId==null){
            throw new AppBadRequestException("student entity not found");
        }
        return byId.get();
    }

    public List<CourseDTO> getAll() {
        Iterable<CourseEntity> all = courseRepository.findAll();
        List<CourseDTO> courseEntities=new LinkedList<>();
        all.forEach(courseEntity -> {
            CourseDTO courseDTO=new CourseDTO();
            courseDTO.setId(courseEntity.getId());
            courseDTO.setPrice(courseEntity.getPrice());
            courseDTO.setDuration(courseEntity.getDuration());
            courseDTO.setCreated_date(courseEntity.getCreated_date());
            courseEntities.add(courseDTO);
        });
        return courseEntities;
    }

    public Boolean update(Integer id, CourseDTO courseDTO) {
        CourseEntity course = get(id);
        CourseEntity courseEntity=new CourseEntity();
        courseEntity.setName(courseDTO.getName());
        courseEntity.setPrice(courseDTO.getPrice());
        courseEntity.setDuration(courseDTO.getDuration());
        courseEntity.setCreated_date(LocalDate.now());
        courseRepository.delete(course);
        courseRepository.save(courseEntity);
        return true;
    }

    public Boolean delete(Integer id) {
        CourseEntity courseEntity = get(id);
        courseRepository.delete(courseEntity);
        return null;
    }

    public Object getByName(String name) {

        return null;
    }

    public List<CourseDTO> getBetWeen(Integer dur1, Integer dur2) {
        List<CourseEntity> all = courseRepository.getCourseEntitiesByDurationBetween(dur1, dur2);
        List<CourseDTO> courseEntities=new LinkedList<>();
        all.forEach(courseEntity -> {
            CourseDTO courseDTO=new CourseDTO();
            courseDTO.setId(courseEntity.getId());
            courseDTO.setPrice(courseEntity.getPrice());
            courseDTO.setDuration(courseEntity.getDuration());
            courseDTO.setCreated_date(courseEntity.getCreated_date());
            courseEntities.add(courseDTO);
        });
        return courseEntities;
    }
}
