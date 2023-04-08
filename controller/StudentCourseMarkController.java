package com.example.lesson_72.controller;

import com.example.lesson_72.dto.StudentCourseMarkDTO;
import com.example.lesson_72.service.StudentCourseMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.SpinnerUI;
import java.time.LocalDate;

@RestController
@RequestMapping("/student_mark")
public class StudentCourseMarkController {
    @Autowired
    private StudentCourseMarkService service;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody StudentCourseMarkDTO studentCourseMarkDTO){
        return ResponseEntity.ok(service.create(studentCourseMarkDTO));
    }

    @GetMapping(value = "/getById{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping(value = "/getBy{id}")
    public ResponseEntity<?> getBy(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping(value = "/update{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody StudentCourseMarkDTO dto){
        return ResponseEntity.ok(service.update(id,dto));
    }
    @DeleteMapping(value = "/deleteById{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping(value = "/getDaysMark{date}")
    public ResponseEntity<?> getDaysMark(@PathVariable("date")LocalDate date){
        return ResponseEntity.ok(service.getDaysMark(date));
    }
}
