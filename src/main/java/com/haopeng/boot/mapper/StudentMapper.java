package com.haopeng.boot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haopeng.boot.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {


    public Student getStudent(Integer id );


}
