package com.study.study_springboots.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.study_springboots.dao.CommonCodeOurDao;
import com.study.study_springboots.utils.Paginations;

@Service
public class CommonCodeOurService {
    @Autowired
    CommonCodeOurDao commonCodeOurDao;    // 레파지토리에 있는 Dao 연결

    @Autowired
    AttachFileService attachFileService;

    // getOne과 AttachFiles 같이
    public Object getOneWithAttachFiles(Object dataMap) {
        // AttachFiles ArrayList<Map>를 찾아오기
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("attachFiles", attachFileService.getList(dataMap)); // 없어지는 결과라 코드를 새로 넣어줌

        // 기존 값 보존 위해, 사용 루핑을 안돌리는 방법으로 putAll해줌
        result.putAll((Map)this.getOne(dataMap)); // commonCode에 대한 것만
        return result;
    }
    
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
        Object result = attachFileService.insertMulti(dataMap);
        result = this.insertOne(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    // 0130 페이지네이션 total과 list
    public Object getListWithPagination(Object dataMap) { 
        Map<String, Object> result = new HashMap<String, Object>();
        int totalCount = (int) this.getTotal(dataMap);
        int currentPage = (int) ((Map<String, Object>) dataMap).get("currentPage");
        Paginations paginations = new Paginations(totalCount, currentPage);
        result.put("paginations", paginations);
        result.put("resultList", this.getList(dataMap));
        return result;
    }

    // 0130 페이지네이션 total
    public Object getTotal(Object dataMap) {
        String sqlMapId = "CommonCodeOur.selectTotal";
        Object result = commonCodeOurDao.getOne(sqlMapId, dataMap);
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

    // dao는 재활용
    public Object deleteMulti(Object dataMap) {
        String sqlMapId = "CommonCodeOur.deleteMultiByUIDs";
        Object result = commonCodeOurDao.delete(sqlMapId, dataMap);
        return result;
    }
}
