package ru.geekbrains.studentslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.studentslist.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
