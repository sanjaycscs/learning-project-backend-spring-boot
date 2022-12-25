package com.runshaw.myapp.controller;

import com.runshaw.myapp.model.Student;
import com.runshaw.myapp.repository.StudentRepository;
import com.runshaw.myapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

//    Insert
    @PostMapping("/save")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

//    Read
    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

//    Update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        Optional<Student> student1 = studentRepository.findById(id);

        if (student1.isEmpty())
            return ResponseEntity.notFound().build();

        student.setId(id);
        studentRepository.save(student);
        return ResponseEntity.noContent().build();
    }

//    Delete
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
}
