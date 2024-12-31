package com.example.reactCrud.Repo;

import com.example.reactCrud.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
