package com.example.crm.service;


import com.example.crm.model.Student;
import com.example.crm.model.StudentRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    void creat(StudentRequest request);
    void update(String id,String email);
    List<Student> getAllSortedByName();

    List<Student> getAllSortedByEmail();

    List<String> getAllName();

    String getNameById(String id);

    void deleteById(String id);

    Student getOneById(String id);

    Student findOneByEmail(String email);

    Page<Student> findAll(Integer index, Integer size, List<String> sorts);
}
