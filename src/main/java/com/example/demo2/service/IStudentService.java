package com.example.demo2.service;

import com.example.demo2.model.Student;

import java.util.List;

public interface IStudentService
{
    Student getStudent(Integer id);
    List<Student> getAllStudents();
    String createStudent(Student student);
    String updateStudent(Student updatedStudentDetails);
    String deleteStudent(Integer id);
}
