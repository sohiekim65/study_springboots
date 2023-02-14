package com.study.study_springboots.controller;

import org.springframework.web.bind.annotation.RestController;

import com.study.study_springboots.service.CommonCodeOurService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// 기존 controller의 완성된 html을 전달하는 것이 아닌 데이터만 전달하는 controller
@RestController
@CrossOrigin
public class RestfulController {

    @RequestMapping(value = "/api/v1/helloworld", method = RequestMethod.GET)
    public String helloworld() {
        return "hello world !";
    }

    // params에 어떤 값을 실어서 보냄
    // params - title:"learn ajax!", description: "we learn with ajax!" --> postman에서 쏠 때 넣어줌
    @RequestMapping(value = "/api/v1/requestParams", method = RequestMethod.GET)
    public Map requestParams(@RequestParam Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.putAll(params);
        result.put("id", "sohiekim");
        return result;
    }

    @Autowired
    CommonCodeOurService commonCodeOurService;

    // currentPage : 1
    @RequestMapping(value = "/api/v1/requestParamsWithDB", method = RequestMethod.POST)
    public Map requestParamsWithDB(@RequestParam Map<String, Object> params) {
        params.put("currentPage", Integer.parseInt((String)params.get("currentPage")));
        params.put("pageScale", 10); 

        Map<String, Object> resultMap = new HashMap<>();
        resultMap = (Map<String, Object>) commonCodeOurService.getListWithPagination(params);

        return resultMap;
    }
}
