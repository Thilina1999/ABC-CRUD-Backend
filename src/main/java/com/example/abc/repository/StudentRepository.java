package com.example.abc.repository;

import com.example.abc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByIndexNo(String indexNo);
}
