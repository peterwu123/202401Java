package com.example.crm.service;

import com.example.crm.dao.TeacherDao;
import com.example.crm.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherImplement implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Teacher findOneById(Integer id) {
        Optional<Teacher> teacherOptional = teacherDao.findById(id);
        return teacherOptional.orElse(null);
    }
}
