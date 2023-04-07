package com.example.lesson_72.controller;

import com.example.lesson_72.dto.CourseDTO;
import com.example.lesson_72.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course_test")
public class CourseController {
    @Autowired
    private CourseService service;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok(service.create(courseDTO));
    }

    @GetMapping(value="/getById")
    public ResponseEntity<?> getById(@RequestBody  Integer id){
        CourseDTO byId = service.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> getAll(){
        List<CourseDTO> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping(value = "/updateAll/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok(service.update(id,courseDTO));
    }

    @DeleteMapping(value = "/delete{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name ){
        return ResponseEntity.ok(service.getByName(name));
    }

    @GetMapping(value = "/getBetweenDuration{dur1}{dur2}")
    public ResponseEntity<?> getBetween(@PathVariable("dur1") Integer dur1,@PathVariable("dur2") Integer dur2){
        return ResponseEntity.ok(service.getBetWeen(dur1,dur2));
    }
}
