package com.haopeng.boot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haopeng.boot.bean.Student;
import com.haopeng.boot.bean.User;
import com.haopeng.boot.mapper.UserMapper;
import com.haopeng.boot.service.StudentService;
import com.haopeng.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    /**
     * 去登陆页面
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }


    /**
     * 去main页面
     * @return
     */
    @PostMapping("/login")
    public String main(User user , HttpSession session, Model model){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        //System.out.println("user = " + user );
        if (userMapper.selectOne(queryWrapper) != null) {
           if (userMapper.selectOne(queryWrapper).getPassword().equals(user.getPassword())){
               return "redirect:/main";
           }else {
               model.addAttribute("pwdmsg","密码错误");
               return "/login";
           }
        }else{
            model.addAttribute("usermsg","账户不存在！");
            return "/login";
        }

    }

    //@GetMapping("/main")
    //public String mainPage(){
    //    return "main";
    //}

    @GetMapping("/main")
    public String mainPage(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //List<Student> list = studentService.list();
        //model.addAttribute("students",list);
        Page<Student> studentpage = new Page<>(pn,5);
        Page<Student> students=studentService.page(studentpage,null);
        long current = students.getCurrent();
        long pages = students.getPages();
        long total = students.getTotal();
        List<Student> records = students.getRecords();
        model.addAttribute("students",students);
        return "main";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id")Integer id){

        studentService.removeById(id);
        return "redirect:/main";

    }


    //@RequestMapping("/student/save")
    //*public String saveStudent(@RequestParam("name")String name,@RequestParam("sex")String sex,
    //*                          @RequestParam("email")String email,@RequestParam("phone")String phone,
    //*                          @RequestParam("address")String address,Model model){
    //*    studentService.insert_into(new Student(name,sex,email,phone,address));
    //*    return "redirect:/main";
    //*}
    //**

    /**
     * 添加学生
     * @param student
     * @param session
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/student/save",method = RequestMethod.POST)
    public String saveStudent(Student student,HttpSession session,Model model){
        session.setAttribute("saveStudent",student);
        System.out.println("student = [" + student + "], session = [" + session + "], model = [" + model + "]");
        studentService.save(student);
        return "redirect:/main";
    }

    @PostMapping("/student/update")
    public String updateStudent(Student student){
        studentService.update(student);
        return "redirect:/main";
    }

}
