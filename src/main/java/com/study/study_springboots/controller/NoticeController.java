package com.study.study_springboots.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.study_springboots.beans.BoardBean;
import com.study.study_springboots.service.DataInfors;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        DataInfors dataInfors = new DataInfors();
        ArrayList<BoardBean> noticeList = dataInfors.getDataListWithBoardBean();
        modelAndView.addObject("noticeList", noticeList);

        modelAndView.setViewName("notice/list");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{title}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String title, ModelAndView modelAndView){
        DataInfors dataInfors = new DataInfors();
        HashMap<String, Object> hashMap = dataInfors.getDataByUid(title);
        modelAndView.addObject("hashMap", hashMap);

        modelAndView.setViewName("notice/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public ModelAndView view(@RequestParam HashMap<String, String> params, ModelAndView modelAndView){
        DataInfors dataInfors = new DataInfors();
        HashMap<String, Object> viewData = dataInfors.getDataByParam(params);

        modelAndView.addObject("viewData", viewData);
        modelAndView.setViewName("notice/view");
        return modelAndView;
    }
}
