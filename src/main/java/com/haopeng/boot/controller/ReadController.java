package com.haopeng.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReadController {


    @GetMapping("/read")
    public String readpage(){
        return "/read";
    }
}
