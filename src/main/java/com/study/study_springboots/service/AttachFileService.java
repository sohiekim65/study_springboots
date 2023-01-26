package com.study.study_springboots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.study_springboots.dao.AttachFileDao;

@Service
public class AttachFileService {
    @Autowired
    AttachFileDao attachFileDao;    // 레파지토리에 있는 Dao 연결
    
    // 비즈니스
    // delete를 하면서 List를 뱉어내는 function
    public Object deleteAndGetList(Object dataMap) {
        Object result = this.delete(dataMap); // 아래 delete function 불러오기
        result = this.getList(dataMap);
        return result;
    }

    // deleteMulti를 하면서 List를 뱉어내는 function
    public Object deleteMultiAndGetList(Object dataMap) {
        Object result = this.deleteMulti(dataMap); // 아래 deleteMulti function 불러오기
        result = this.getList(dataMap);
        return result;
    }

    // update를 하면서 List를 뱉어내는 function
    public Object updateAndGetList(Object dataMap) {
        Object result = this.updateOne(dataMap); // 아래 update function 불러오기
        result = this.getList(dataMap);
        return result;
    }

    // insert를 하면서 List를 뱉어내는 function
    public Object insertAndGetList(Object dataMap) {
        Object result = this.insertOne(dataMap); // 아래 insert function 불러오기
        result = this.getList(dataMap);
        return result;
    }

    // 파일업로드하고 List를 뱉어내는 function
    public Object insertWithFilesAndGetList(Object dataMap) {
        // insert files
        Object result = this.insertOne(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object getList(Object dataMap) { // dataMap은 브라우저에서 넘어오니까 파라미터로
        String sqlMapId = "AttachFile.selectListByUID"; // 사용자가 넘겨주는 게 아니라 여기서 세팅
        Object result = attachFileDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(Object dataMap) {
        String sqlMapId = "AttachFile.selectByUID";
        Object result = attachFileDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object updateOne(Object dataMap) {
        String sqlMapId = "AttachFile.updateByUID";
        Object result = attachFileDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object insertOne(Object dataMap) {
        String sqlMapId = "AttachFile.insertWithUID";
        Object result = attachFileDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object insertMulti(Object dataMap) {
        String sqlMapId = "AttachFile.insertMulti";
        Object result = attachFileDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object delete(Object dataMap) {
        String sqlMapId = "AttachFile.deleteByUID";
        Object result = attachFileDao.delete(sqlMapId, dataMap);
        return result;
    }

    // dao는 재활용
    public Object deleteMulti(Object dataMap) {
        String sqlMapId = "AttachFile.deleteMultiByUIDs";
        Object result = attachFileDao.delete(sqlMapId, dataMap);
        return result;
    }
}
