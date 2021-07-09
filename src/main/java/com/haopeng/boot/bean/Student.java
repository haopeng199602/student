package com.haopeng.boot.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Data
public class Student {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
    private String email;
    private String phone;
    private String address;

    @Autowired
    private Classes classes;

    public Student(String studentName, String sex, String email, String phone, String address) {
        this.name = studentName;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
