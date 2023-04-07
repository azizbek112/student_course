package com.example.lesson_72.controller;

import com.example.lesson_72.dto.StudentDTO;
import com.example.lesson_72.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody StudentDTO studentDTO){
        StudentDTO studentDTO1 = studentService.create(studentDTO);
        return ResponseEntity.ok(studentDTO1);
    }

    @GetMapping(value="/List")
    public ResponseEntity<List<StudentDTO>> getAll(){
        List<StudentDTO> all = studentService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/getById{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        StudentDTO studentDTO = studentService.getById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @PutMapping(value = "/update{id}")
    public ResponseEntity<?> updating(@PathVariable("id") Integer id,@RequestBody StudentDTO studentDTO){
        boolean update = studentService.update(id, studentDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping(value = "/delete{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean delete = studentService.delete(id);
        return ResponseEntity.ok(delete);
    }

    @GetMapping(value = "/getByName{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name ){
        return ResponseEntity.ok(studentService.getByName(name));
    }
    ///TODO
    @GetMapping(value = "/getByCreated_date{date}")
    public ResponseEntity<?> getByDate(@PathVariable("date") LocalDate date){
        return ResponseEntity.ok(studentService.getByCreatedDate(date));
    }
    ///TODO
//    @GetMapping(value = "/getByCreated_DateBetweenDate{date1 date2}")
//    public ResponseEntity<?> getBetween(@PathVariable("date1") LocalDate date,@PathVariable("date2") LocalDate time){
//        List<StudentDTO> between = studentService.getBetween(date, time);
//        return ResponseEntity.ok(between);
//    }
}
