package com.example.demo2.service;

import com.example.demo2.model.Student;
import com.example.demo2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class IStudentServiceImpl implements IStudentService{
    List<Student> studentList=new ArrayList<>();
    private final StudentRepository studentRepository;

    public IStudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(Integer id) {
//        Optional<Student> optionalStudent=studentList.stream()
//                .filter(s->s.getId().equals(id)).findFirst();
//        if(optionalStudent.isPresent())
//        {
//            return optionalStudent.get();
//        }
//        else {
//            throw new RuntimeException("Student not found with the given Id : "+id);
//        }
        Optional<Student> optionalStudent=studentRepository.findById(id);
        if(optionalStudent.isPresent())
        {
            return optionalStudent.get();
        }
        else {
            throw new RuntimeException("Student not found with the given Id : "+id);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String createStudent(Student student) {
//        studentList.add(student);
//        return "Student created successfully";
        Student dbStudent=new Student(student.getId(),student.getName(),student.getBranch(),student.getAge(),student.getGender());
        studentRepository.save(dbStudent);
        return "Student created successfully";
    }

    @Override
    public String updateStudent(Student updatedStudentDetails) {
//        Optional<Student> optionalStudent=studentList.stream()
//                .filter(s->s.getId().equals(id)).findFirst();
//        if(optionalStudent.isPresent())
//        {
//            Student updatedStudent=optionalStudent.get();
//            updatedStudent.setId(updatedStudentDetails.getId());
//            updatedStudent.setName(updatedStudentDetails.getName());
//            updatedStudent.setBranch(updatedStudentDetails.getBranch());
//            updatedStudent.setAge(updatedStudentDetails.getAge());
//            updatedStudent.setGender(updatedStudentDetails.getGender());
//            return "Student updated successfully "+updatedStudent;
//        }
//        else {
//            throw new RuntimeException("Student not found with the given Id : "+id);
//        }
        Optional<Student> optionalStudent=studentRepository.findById(updatedStudentDetails.getId());
        if(optionalStudent.isPresent())
        {
            Student updatedStudent=optionalStudent.get();
            updatedStudent.setId(updatedStudentDetails.getId());
            updatedStudent.setName(updatedStudentDetails.getName());
            updatedStudent.setBranch(updatedStudentDetails.getBranch());
            updatedStudent.setAge(updatedStudentDetails.getAge());
            updatedStudent.setGender(updatedStudentDetails.getGender());
            studentRepository.save(updatedStudent);
            return "Student updated successfully "+updatedStudent;
        }
        else {
            throw new RuntimeException("Student not found with the given Id : "+updatedStudentDetails.getId());
        }
    }

    @Override
    public String deleteStudent(Integer id) {
//        Optional<Student> optionalStudent=studentList.stream()
//                .filter(s->s.getId().equals(id)).findFirst();
//        if(optionalStudent.isPresent())
//        {
//            studentList.remove(optionalStudent.get());
//            return "Student deleted successfully";
//        }
//        else {
//            throw new RuntimeException("Student not found with the given Id : "+id);
//        }
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return "Student deleted successfully";
        } else {
            throw new RuntimeException("Student not found with the given Id : " + id);
        }
    }
}
