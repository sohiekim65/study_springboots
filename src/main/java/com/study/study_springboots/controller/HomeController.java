package com.study.study_springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 서블릿에서 했었던 urlMapping과 componentScan을 @Controller, @RequestMapping
@Controller // 이 클래스에다가 Controller라고 캡을 씌워서 문지기가 기억하도록
public class HomeController {
    @RequestMapping(value = {"", "/", "/main"}) // url이 이 3개면 main.jsp로 들어오도록(url여러개 가능) 
    public String main(){
        int i = 0;
        return "main";
    }
    @RequestMapping(value = "/home") 
    public void home(){
        int i = 0;
    }
    @RequestMapping(value = "/homejsp") // http://localhost:8080/homejsp
    public String homejsp(){
        int i = 0;
        return "home";  // /homejsp를 호출하면 home.jsp 화면에 보이도록
    }
    @RequestMapping(value = "/homehtml") // http://localhost:8080/homehtml
    public String homehtml(){
        int i = 0;
        return "home.html"; // html은 spring에서 해석하지 않고 jsp만 해석한다(jsp를 해석할 수 있는 건 jasper 라이브러리 덕분).
    }
    @RequestMapping(value = "/jstlformats") 
    public String jstlformats(){
        int i = 0;
        return "jstl_formats"; 
    }
}
