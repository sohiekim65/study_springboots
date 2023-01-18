package com.study.study_springboots.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// @Repository
@Component
public class CommonCodeOurDao {
    @Autowired  // DI해줌
    private SqlSessionTemplate sqlSessionTemplate; // DB와 Mapper XML 연결 클래스

    public Object getList(String sqlMapId, Object dataMap) { 
        Object result = sqlSessionTemplate.selectList(sqlMapId, dataMap); // return 값이 list인데 통틀어 Object로
        return result;
    }
}
