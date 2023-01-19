package com.study.study_springboots.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.study_springboots.service.CommonCodeOurService;

@Controller
@RequestMapping(value = "/commonCodeOur")
public class CommonCodeOurController {

    @Autowired
    CommonCodeOurService commonCodeOurService; // DI

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST) 
    public ModelAndView insert(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        commonCodeOurService.insertOne(params);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/form"}, method = RequestMethod.GET)
    public ModelAndView form(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        modelAndView.setViewName("commonCode_our/edit");    // edit화면 재사용
        return modelAndView;
    }

    @RequestMapping(value = {"/delete/{uniqueId}"}, method = RequestMethod.POST) // --> uniqueId는 list.jsp에서 넘어오는 uid
    public ModelAndView delete(@RequestParam Map<String, Object> params, @PathVariable String uniqueId, ModelAndView modelAndView) {
        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeOurService.deleteAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST) // --> @GetMapping(value = "/list") // 동일 코드
    public ModelAndView update(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = commonCodeOurService.updateAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
    public ModelAndView list(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = commonCodeOurService.getList(params); // params가 서비스의 dataMap
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/edit/{uniqueId}"}, method = RequestMethod.GET) 
    public ModelAndView edit(@RequestParam Map<String, Object> params, @PathVariable String uniqueId, ModelAndView modelAndView) {
        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeOurService.getOne(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/edit");
        return modelAndView;
    }
}
