package com.haopeng.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haopeng.boot.bean.Student;
import com.haopeng.boot.bean.User;
import com.haopeng.boot.mapper.StudentMapper;
import com.haopeng.boot.mapper.UserMapper;
import com.haopeng.boot.service.StudentService;
import com.haopeng.boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SbCrudApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService;

    /**
     * mapper类测试有效
     */
    @Test
    void contextLoads() {
        Student student = studentMapper.getStudent(1);
        System.out.println("================================");
        System.out.println(student);
    }


    /**
     *分页插件测试有效
     */
    @Test
    void pagetest(){
        Page<Student> studentpage = new Page<>(1,5);
        Page<Student> page=studentService.page(studentpage,null);
        long current = page.getCurrent();
        long pages = page.getPages();
        List<Student> records = page.getRecords();
        System.out.println(records);
    }

    @Test
    public void selectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "admin");

        User user = userMapper.selectOne(queryWrapper);
        User testuser = new User("admin","123456");

        System.out.println(userMapper.selectOne(queryWrapper).getPassword().equals(testuser.getPassword()));
    }
}
