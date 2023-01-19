package com.study.study_springboots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.study_springboots.dao.CommonCodeOurDao;

@Service
public class CommonCodeOurService {
    @Autowired
    CommonCodeOurDao commonCodeOurDao;    // 레파지토리에 있는 Dao 연결
    
    // 비즈니스
    // delete를 하면서 List를 뱉어내는 function
    public Object deleteAndGetList(Object dataMap) {
        Object result = this.delete(dataMap); // 아래 delete function 불러오기
        result = this.getList(dataMap);
        return result;
    }

    // update를 하면서 List를 뱉어내는 function
    public Object updateAndGetList(Object dataMap) {
        Object result = this.updateOne(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    // insert를 하면서 List를 뱉어내는 function
    public Object insertAndGetList(Object dataMap) {
        Object result = this.insertOne(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object getList(Object dataMap) { // dataMap은 브라우저에서 넘어오니까 파라미터로
        String sqlMapId = "CommonCodeOur.selectListByUID"; // 사용자가 넘겨주는 게 아니라 여기서 세팅
        Object result = commonCodeOurDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.selectByUID";
        Object result = commonCodeOurDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object updateOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.updateByUID";
        Object result = commonCodeOurDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object insertOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.insertWithUID";
        Object result = commonCodeOurDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object delete(Object dataMap) {
        String sqlMapId = "CommonCodeOur.deleteByUID";
        Object result = commonCodeOurDao.delete(sqlMapId, dataMap);
        return result;
    }
}
