package com.haopeng.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haopeng.boot.bean.Student;
import com.haopeng.boot.mapper.StudentMapper;
import com.haopeng.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl  extends ServiceImpl<StudentMapper,Student> implements StudentService {

    @Autowired
    StudentMapper studentMapper;


    @Override
    public void update(Student student) {

    }

    @Override
    public void insert_into(Student student) {


    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudent(id);
    }
}
