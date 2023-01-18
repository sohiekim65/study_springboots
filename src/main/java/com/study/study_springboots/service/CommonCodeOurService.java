package com.study.study_springboots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.study_springboots.dao.CommonCodeOurDao;

@Service
public class CommonCodeOurService {
    @Autowired
    CommonCodeOurDao commonCodeOurDao;    // 레파지토리에 있는 Dao 연결

    // 비즈니스
    public Object getList(Object dataMap) { // dataMap은 브라우저에서 넘어오니까 파라미터로
        String sqlMapId = "CommonCodeOur.selectListByUID"; // 사용자가 넘겨주는 게 아니라 여기서 세팅
        Object result = commonCodeOurDao.getList(sqlMapId, dataMap);
        return result;
    }
}
