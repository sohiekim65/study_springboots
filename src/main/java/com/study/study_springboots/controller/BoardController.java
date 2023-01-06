package com.study.study_springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// - 항목 : title, content, userName, date
// - CRUD :
// + list.jsp(/board) -> view.jsp(/board/view) -> list.jsp(/board/list)
// + list.jsp(/board) -> form.jsp(/board/form) -> form.jsp(/board/form) with Post -> list.jsp(/board/list)
// + view.jsp(/board/view) -> edit.jsp(/board/edit) -> list.jsp(/board/list)

// @Controller
public class BoardController {
    // get방식(a태그처럼 get방식)
    // @RequestMapping(value = "/board/form", method = RequestMethod.GET)
    public String form(){
        return "/WEB-INF/views/board/form.jsp";
    }
    // @RequestMapping(value = "/board/form", method = RequestMethod.POST)
    public String formPost(){
        return "/WEB-INF/views/board/list.jsp";
    }
    // @RequestMapping(value = {"/board", "/board/list"}, method = RequestMethod.GET)
    public String list(){
        return "/WEB-INF/views/board/list.jsp";
    }
    // @RequestMapping(value = "/board/view", method = RequestMethod.GET)
    public String view(){
        return "/WEB-INF/views/board/view.jsp";
    }
    // @RequestMapping(value = "/board/edit", method = RequestMethod.GET)
    public String edit(){
        return "/WEB-INF/views/board/edit.jsp";
    }
    
}
