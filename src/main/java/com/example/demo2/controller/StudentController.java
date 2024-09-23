package com.example.demo2.controller;
import com.example.demo2.model.Student;
import com.example.demo2.service.IStudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController
{
    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iStudentService.getStudent(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>>getAllStudents()
    {
        return ResponseEntity.ok(iStudentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student)
    {
        return ResponseEntity.ok(iStudentService.createStudent(student));
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student updatedStudentdetails)
    {
        return ResponseEntity.ok(iStudentService.updateStudent(updatedStudentdetails));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iStudentService.deleteStudent(id));
    }
}
