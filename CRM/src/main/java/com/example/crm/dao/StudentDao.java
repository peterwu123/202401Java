package com.example.crm.dao;

import com.example.crm.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentDao extends JpaRepository<Student, String> {

    @Query(value = "SELECT s FROM Student s WHERE s.email=?1")
    Student findByEmail(String email);
}
