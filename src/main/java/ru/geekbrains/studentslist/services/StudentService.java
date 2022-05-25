package ru.geekbrains.studentslist.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.studentslist.entities.Student;
import ru.geekbrains.studentslist.repositories.StudentRepository;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void changeStudent(Long studentId, String name, Integer age) {
        if (Objects.nonNull(studentId)) {
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Unable to change student's score. Student not found, id: " + studentId));
            if (Objects.nonNull(name) && !name.isBlank()) {
                student.setName(name);
            }
            if (Objects.nonNull(age)) {
                student.setAge(age);
            }
        }
    }

    @Resource
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
