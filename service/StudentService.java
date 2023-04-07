package com.example.lesson_72.service;

import com.example.lesson_72.dto.StudentDTO;
import com.example.lesson_72.entity.StudentEntity;
import com.example.lesson_72.exp.AppBadRequestException;
import com.example.lesson_72.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO create(StudentDTO studentDTO){
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setName(studentDTO.getName());
        studentEntity.setSurname(studentDTO.getSurname());
        if(studentDTO.getName()==null || studentDTO.getName().isBlank()){
            throw new AppBadRequestException("Student name qani ?");
        }
        if (studentDTO.getSurname()== null|| studentDTO.getSurname().isBlank()){
            throw new AppBadRequestException("Student surname qani ?");
        }
        studentEntity.setGender(studentDTO.getGender());
        studentRepository.save(studentEntity);
        studentDTO.setId(studentEntity.getId());
        return studentDTO;
    }
    public List<StudentDTO> getAll(){
        Iterable<StudentEntity> all = studentRepository.findAll();
        List<StudentDTO> dtoList=new LinkedList<>();
        all.forEach(studentEntity -> {
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setGender(studentEntity.getGender());
            studentDTO.setSurname(studentEntity.getSurname());
            studentDTO.setName(studentEntity.getName());
            studentDTO.setLevel(studentEntity.getLevel());
            studentDTO.setId(studentEntity.getId());
            dtoList.add(studentDTO);
        });
        return dtoList;
    }
    public StudentDTO getById(Integer id) {
        StudentEntity studentEntity = get(id);
        StudentDTO studentDTO=new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setName(studentEntity.getName());
        studentDTO.setSurname(studentEntity.getSurname());
        studentDTO.setLevel(studentDTO.getLevel());
        return studentDTO;
    }
    public StudentEntity get(Integer id){
        Optional<StudentEntity> byId = studentRepository.findById(id);
        if (byId==null){
            throw new AppBadRequestException("student entity not found");
        }
        return byId.get();
    }
    public boolean update(Integer id, StudentDTO studentDTO) {
        StudentEntity studentEntity = get(id);
        studentEntity.setName(studentDTO.getName());
        studentEntity.setSurname(studentDTO.getSurname());
        studentEntity.setGender(studentDTO.getGender());
        studentRepository.save(studentEntity);
        return true;
    }
    public boolean delete(Integer id) {
        StudentEntity studentEntity = get(id);
        studentRepository.delete(studentEntity);
        return true;
    }
    public List<StudentDTO> getByName(String name) {
        List<StudentEntity> studentEntitiesByName = studentRepository.getStudentEntitiesByName(name);
        if (studentEntitiesByName == null){
            throw new AppBadRequestException("Student doesn't exist! ");
        }
        List<StudentDTO> studentDTOS=new LinkedList<>();
        studentEntitiesByName.forEach(studentEntity -> {
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setId(studentEntity.getId());
            studentDTO.setName(studentEntity.getName());
            studentDTO.setLevel(studentEntity.getLevel());
            studentDTO.setGender(studentEntity.getGender());
            studentDTO.setSurname(studentEntity.getSurname());
            studentDTO.setAge(studentEntity.getAge());
            studentDTOS.add(studentDTO);
        });
        return studentDTOS;
    }
    public List<StudentDTO> getBySurName(String name) {
        List<StudentEntity> studentEntitiesByName = studentRepository.getStudentEntitiesBySurname(name);
        if (studentEntitiesByName == null){
            throw new AppBadRequestException("Student doesn't exist! ");
        }
        List<StudentDTO> studentDTOS=new LinkedList<>();
        studentEntitiesByName.forEach(studentEntity -> {
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setId(studentEntity.getId());
            studentDTO.setName(studentEntity.getName());
            studentDTO.setLevel(studentEntity.getLevel());
            studentDTO.setGender(studentEntity.getGender());
            studentDTO.setSurname(studentEntity.getSurname());
            studentDTO.setAge(studentEntity.getAge());
            studentDTOS.add(studentDTO);
        });
        return studentDTOS;
    }
    public List<StudentDTO> getByLevel(int name) {
        List<StudentEntity> studentEntitiesByName = studentRepository.getStudentEntitiesByLevel(name);
        if (studentEntitiesByName == null){
            throw new AppBadRequestException("Student doesn't exist! ");
        }
        List<StudentDTO> studentDTOS=new LinkedList<>();
        studentEntitiesByName.forEach(studentEntity -> {
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setId(studentEntity.getId());
            studentDTO.setName(studentEntity.getName());
            studentDTO.setLevel(studentEntity.getLevel());
            studentDTO.setGender(studentEntity.getGender());
            studentDTO.setSurname(studentEntity.getSurname());
            studentDTO.setAge(studentEntity.getAge());
            studentDTOS.add(studentDTO);
        });
        return studentDTOS;
    }
    public List<StudentDTO> getByCreatedDate(LocalDate date) {
//        List<StudentEntity> studentEntitiesByName = studentRepository.getStudentEntitiesByCreated_date(date);
//        if (studentEntitiesByName == null){
//            throw new AppBadRequestException("Student doesn't exist! ");
//        }
        List<StudentDTO> studentDTOS=new LinkedList<>();
//        studentEntitiesByName.forEach(studentEntity -> {
//            StudentDTO studentDTO=new StudentDTO();
//            studentDTO.setId(studentEntity.getId());
//            studentDTO.setName(studentEntity.getName());
//            studentDTO.setLevel(studentEntity.getLevel());
//            studentDTO.setGender(studentEntity.getGender());
//            studentDTO.setSurname(studentEntity.getSurname());
//            studentDTO.setAge(studentEntity.getAge());
//            studentDTOS.add(studentDTO);
//        });
        return studentDTOS;
    }
    public List<StudentDTO> getBetween(LocalDate date, LocalDate time) {
//        List<StudentEntity> between = studentRepository.getStudentEntitiesByCreated_dateBetweenAndCreated_date(date, time);
//        if (between == null){
//            throw new AppBadRequestException("Student is empty");
//        }
        List<StudentDTO> studentDTOS=new LinkedList<>();
//        between.forEach(studentEntity -> {
//            StudentDTO studentDTO=new StudentDTO();
//            studentDTO.setId(studentEntity.getId());
//            studentDTO.setName(studentEntity.getName());
//            studentDTO.setLevel(studentEntity.getLevel());
//            studentDTO.setGender(studentEntity.getGender());
//            studentDTO.setSurname(studentEntity.getSurname());
//            studentDTO.setAge(studentEntity.getAge());
//            studentDTOS.add(studentDTO);
//        });
        return studentDTOS;
    }
}
