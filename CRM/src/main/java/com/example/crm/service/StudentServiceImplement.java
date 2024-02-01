package com.example.crm.service;

import com.example.crm.dao.StudentDao;
import com.example.crm.model.Student;
import com.example.crm.model.StudentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplement implements StudentService{



    @Autowired
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentServiceImplement(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void creat(StudentRequest request) {
        Student student = new Student();
        BeanUtils.copyProperties(request, student);
        studentDao.save(student);
    }

    @Override
    public void update(String id, String email) {
        Student student = studentDao.getById(id);
        if(student == null){
            System.out.println(String.format("student with id %s not found!", id));
            return;
        }else {
            student.setEmail(email);
            studentDao.save(student);
        }
    }

    @Override
    public List<Student> getAllSortedByName() {
        List<Student> list = studentDao.findAll();
        Collections.sort(list);
        return list;
    }

    @Override
    public List<Student> getAllSortedByEmail() {
        List<Student> list = studentDao.findAll();
        return list.stream().sorted(((o1, o2) -> o1.getEmail().compareTo(o2.getEmail()))).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllName(){
        List<Student> list = studentDao.findAll();
        return list.stream().map(student -> student.getName()).collect(Collectors.toList());
    }

    @Override
    public String getNameById(String id) {
        // null-pointer
        Student student = studentDao.getOne(id);
        return student.getName();
    }

    @Override
    public void deleteById(String id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student getOneById(String id) {
        return studentDao.getById(id);
    }


    @Override
    public Student findOneByEmail(String email) {
        return studentDao.findByEmail(email);
    }

    @Override
    public Page<Student> findAll(Integer index, Integer size, List<String> sorts) {

        List<Sort.Order> orders = sorts.stream().map(s -> Sort.Order.by(s)).collect(Collectors.toList());
        PageRequest pageRequest = PageRequest.of(index, size, Sort.by(orders));
        return studentDao.findAll(pageRequest);
    }


}
