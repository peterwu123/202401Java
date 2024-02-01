package com.example.crm.controller;

import com.example.crm.model.Student;
import com.example.crm.model.StudentRequest;
import com.example.crm.service.StudentService;
import com.example.crm.service.StudentServiceImplement;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping(value = "/allEmail")
    public List<Student> allEmail(){
        return service.getAllSortedByEmail();
    }

    @GetMapping(value = "/allName")
    public List<Student> allName(){
        return service.getAllSortedByEmail();
    }

    @PostMapping(value = "/student")
    public String create(@RequestBody StudentRequest request){ // bean,entity.pojo
        service.creat(request);
        return "success";
    }

    @PutMapping(value = "/student")
    public String update(@RequestParam(name = "id") String studentId,@RequestParam String email){
        service.update(studentId, email);
        return "success";
    }

    @DeleteMapping(value = "/student")
    public String delete(@RequestParam String id){
        service.deleteById(id);
        return "success";
    }

    @GetMapping(value = "/student/{id}")// {id} -> placeholder
    public Student getById(@PathVariable(name = "id") String id){
        return service.getOneById(id);
    }

    @GetMapping(value = "/student/email")
    public Student getByEmail(@RequestParam String email){
        return service.findOneByEmail(email);
    }

    @GetMapping(value = "/student/page")
    public Page<Student> getByPage(@RequestParam Integer index, @RequestParam Integer size, @RequestBody List<String> sorts){
        return service.findAll(index, size, sorts);
    }

    @GetMapping(value = "/student/name/{id}")
    public String getNameById(@PathVariable String id){
        return service.getNameById(id);
    }
}
