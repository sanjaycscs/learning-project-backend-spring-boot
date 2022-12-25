package com.runshaw.myapp.service;

import com.runshaw.myapp.model.Student;
import com.runshaw.myapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

//    Insert Data into Database
    public Student saveStudent(Student student) {
        try{
            studentRepository.save(student);
        } catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }


//    Get list of all the data from the Database
    public List<Student> getAllStudents() {
        List<Student> students= studentRepository.findAll();
        return students;
    }

//    Delete data from Database
    public ResponseEntity<?> deleteStudent(Integer id){
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
