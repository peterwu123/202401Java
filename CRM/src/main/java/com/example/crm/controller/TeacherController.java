package com.example.crm.controller;

import com.example.crm.model.Student;
import com.example.crm.model.Teacher;
import com.example.crm.service.StudentService;
import com.example.crm.service.StudentServiceImplement;
import com.example.crm.service.TeacherImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherImplement teacherImplement;

    @GetMapping(value = "/teacher/{id}")
    public Teacher getAllStudent(@PathVariable Integer id){
        return teacherImplement.findOneById(id);
    }
}
