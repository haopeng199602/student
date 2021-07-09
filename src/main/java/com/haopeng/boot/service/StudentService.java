package com.haopeng.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haopeng.boot.bean.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService extends IService<Student> {

    public Student getStudentById(Integer id);

    void update(Student student);

    void insert_into(Student student);

}
