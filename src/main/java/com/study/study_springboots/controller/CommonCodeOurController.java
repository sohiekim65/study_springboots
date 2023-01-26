package com.study.study_springboots.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.study.study_springboots.service.CommonCodeOurService;

@Controller
@RequestMapping(value = "/commonCodeOur")
public class CommonCodeOurController {

    @Autowired
    CommonCodeOurService commonCodeOurService; // DI

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST) 
    public ModelAndView insert(MultipartHttpServletRequest multipartHttpServletRequest
                    , @RequestParam Map<String, Object> params
                    , ModelAndView modelAndView) throws IOException {

        String registerSeq = multipartHttpServletRequest.getParameter("REGISTER_SEQ");
        
        MultipartFile multipartFile =  multipartHttpServletRequest.getFile("file_first"); // 뭉치 그대로 가져오기
        String fileName = multipartFile.getOriginalFilename(); // 파일Name 가져오기
        
        String relativePath = "src\\main\\resources\\static\\files\\"; // 파일 저장할 경로
        // file 저장
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(relativePath+fileName));
        // 이제부터 쓸거야
        bufferedWriter.write(new String(multipartFile.getBytes())); // 뭉치를 가져오고 그 뭉치를 String으로 바꾸고 write해주면 공간에 써짐
        bufferedWriter.flush();

        Object resultMap = commonCodeOurService.insertAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/insertMulti"}, method = RequestMethod.POST) 
    public ModelAndView insertMulti(MultipartHttpServletRequest multipartHttpServletRequest
                    , @RequestParam Map<String, Object> params
                    , ModelAndView modelAndView) throws IOException {
        
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/form"}, method = RequestMethod.GET)
    public ModelAndView form(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        modelAndView.setViewName("commonCode_our/edit");    // edit화면 재사용
        return modelAndView;
    }

    @RequestMapping(value = {"/formMulti"}, method = RequestMethod.GET)
    public ModelAndView formMulti(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        modelAndView.setViewName("commonCode_our/editMulti");    // edit화면 재사용
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

    @RequestMapping(value = {"/deleteMulti"}, method = RequestMethod.POST) // --> uniqueId는 list.jsp에서 넘어오는 uid
    public ModelAndView deleteMulti(HttpServletRequest httpServletRequest, @RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        String[] deleteMultis = httpServletRequest.getParameterMap().get("COMMON_CODE_ID");
        params.put("deleteMultis", deleteMultis);
        // Object resultMap = commonCodeOurService.deleteMulti(params);
        Object resultMap = commonCodeOurService.deleteMultiAndGetList(params);
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
