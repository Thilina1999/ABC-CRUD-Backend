package com.example.abc.controller;

import com.example.abc.entity.Student;
import com.example.abc.messages.Message;
import com.example.abc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("get/allStudents")
    private List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping("/save/student")
    private ResponseEntity<Message> saveStudent(@RequestBody Student student){
        return  studentService.saveStudent(student);
    }

    @PutMapping("/update/student/{id}")
    private ResponseEntity<Message> upDateStudent(@PathVariable("id") int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete/student/{id}")
    private ResponseEntity<Message> deleteStudent(@PathVariable("id") int id){
        return studentService.deleteStudent(id);
    }
}
