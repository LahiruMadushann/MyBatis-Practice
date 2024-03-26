package com.example.mybatispractice.controller;

import com.example.mybatispractice.model.Student;
import com.example.mybatispractice.service.StudentMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentMapper studentMapper;

    public StudentController(StudentMapper studentMapper){
        this.studentMapper = studentMapper;

    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentMapper.getStudent(id);

    }

    @PostMapping("/saveStudent")
    public Student insertStudent(@RequestBody Student student){
        studentMapper.insertStudent(student);
        return student;
    }
    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        studentMapper.updateStudent(student);
        return student;

    }
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentMapper.deleteStudent(id);
        return "Deleted";

    }
}
