package ru.geekbrains.studentslist.controllers;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.studentslist.entities.Student;
import ru.geekbrains.studentslist.services.StudentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @PostMapping("/students")
    public Student saveNewStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/students/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PostMapping("/students/change_student")
    public void changeStudent(@RequestBody Student student) {
        studentService.changeStudent(student.getId(), student.getName(), student.getAge());
    }

    @Resource
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
