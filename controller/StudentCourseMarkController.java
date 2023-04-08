package com.example.lesson_72.controller;

import com.example.lesson_72.dto.StudentCourseMarkDTO;
import com.example.lesson_72.service.StudentCourseMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    @GetMapping(value = "/getBetweenDaysMark")
    public ResponseEntity<?> getDaysBetween(@RequestParam("date1") LocalDate date1,@RequestParam("date2") LocalDate date2){
        return ResponseEntity.ok(service.getBetween(date1,date2));
    }
    @GetMapping(value = "/getListMarkOrderByCreatedDate")
    public ResponseEntity<?> getListMark(){
        return ResponseEntity.ok(service.getListMarks());
    }
    @GetMapping(value = "/getListMarkByCourseId{id}")
    public ResponseEntity<?> getMarkListById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getMarkListById(id));
    }
    @GetMapping(value = "/get3MarkList")
    public ResponseEntity<?> getMark3List(){
        return ResponseEntity.ok(service.getMark3List());
    }
    @GetMapping(value = "/get1MarkList")
    public ResponseEntity<?> getMark1List(){
        return ResponseEntity.ok(service.getMark1List());
    }
    @GetMapping(value = "/getCourseMarkList{id}")
    public ResponseEntity<?> getCourseMarkList(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getCourseMarkList(id));
    }
    @GetMapping(value = "/getHighlyMark{id}")
    public ResponseEntity<?> getHighlyMark(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getHighlyMark(id));
    }
    @GetMapping(value = "/getAvgCourseMark{id}")
    public ResponseEntity<?> getAvgCourseMark(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getAvgCourseMark(id));
    }
    @GetMapping(value = "/getCountCourseMark{id}")
    public ResponseEntity<?> getCountsCourseMark(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getCountsCourseMark(id));
    }
}
