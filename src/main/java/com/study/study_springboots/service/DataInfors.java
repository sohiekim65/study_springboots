package com.study.study_springboots.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.study.study_springboots.beans.BoardBean;

public class DataInfors {
    public HashMap<String, String> getSearchFormData() {
        HashMap<String, String> searchForm = new HashMap<String, String>();
        searchForm.put("search_key", "Search Title");
        searchForm.put("name", "요주의랩!");
        searchForm.put("id", "ID0001");
        return searchForm;
    }

    public ArrayList<String> getTablesListWithString(){
        ArrayList<String> tablesListWithString = new ArrayList<String>();
        tablesListWithString.add("@mdo");
        tablesListWithString.add("@fat");
        tablesListWithString.add("@twitter");
        return tablesListWithString;
    }

    public HashMap<String, Object> getBundlesData() {
        DataInfors DataInfors = new DataInfors();
        HashMap<String, String> searchForm = DataInfors.getSearchFormData();
        ArrayList<String> tablesListWithString = DataInfors.getTablesListWithString();

        HashMap<String, Object> bundlesData = new HashMap<>();
        bundlesData.put("searchForm", searchForm);
        bundlesData.put("tablesListWithString", tablesListWithString);

        bundlesData.put("dataWithMemberBean", DataInfors.getDataWithMemberBean());
        bundlesData.put("dataListWithBoardBean", DataInfors.getDataListWithBoardBean());

        return bundlesData;
    }

    public BoardBean getDataWithMemberBean(){
        BoardBean boardBean = new BoardBean();
        boardBean.setTitle("Mark");
        boardBean.setContent("Otto");
        boardBean.setUserName("@mdo");
        
        return boardBean;
    }

    public ArrayList<BoardBean> getDataListWithBoardBean(){
        ArrayList<BoardBean> membersList = new ArrayList<>();
        BoardBean boardBean = new BoardBean();
        boardBean.setTitle("Mark");
        boardBean.setContent("Otto");
        boardBean.setUserName("@mdo");
        boardBean.setDate("22.11.11");
        membersList.add(boardBean);

        boardBean = new BoardBean();
        boardBean.setTitle("Jacob");
        boardBean.setContent("Thornton");
        boardBean.setUserName("@fat");
        boardBean.setDate("22.11.11");
        membersList.add(boardBean);

        boardBean = new BoardBean();
        boardBean.setTitle("Larry");
        boardBean.setContent("Bird");
        boardBean.setUserName("@twitter");
        boardBean.setDate("22.11.11");
        membersList.add(boardBean);

        return membersList;
    }


    // board 실습 데이터
    // list 출력
    public ArrayList<BoardBean> getDataListWithBoardBean2(){
        ArrayList<BoardBean> boardList = new ArrayList<>();
        BoardBean boardBean = new BoardBean();
        boardBean.setTitle("MBTI");
        boardBean.setContent("S와 N 구별법 : 말이 바에 들어가서 바텐더에게");
        boardBean.setUserName("솜솜");
        boardBean.setDate("2023.01.05");
        boardList.add(boardBean);
        
        boardBean = new BoardBean();
        boardBean.setTitle("아바타: 물의 길");
        boardBean.setContent("더 재밌게 보는 방법");
        boardBean.setUserName("CGV");
        boardBean.setDate("2023.01.05");
        boardList.add(boardBean);

        boardBean = new BoardBean();
        boardBean.setTitle("인테리어");
        boardBean.setContent("꿀팁 대방출");
        boardBean.setUserName("오늘의 집");
        boardBean.setDate("2023.01.05");
        boardList.add(boardBean);
        
        return boardList;
    }

    // board 실습 데이터
    // view에서 선택한 board 데이터 출력
    public BoardBean getDataViewWithBoardBean(String title){
        ArrayList<BoardBean> viewList = getDataListWithBoardBean2();
        BoardBean boardBean = new BoardBean();
        for(int i = 0; i < viewList.size(); i++){
            BoardBean view = viewList.get(i);
            if(title.equals(view.getTitle())){
                boardBean.setTitle(view.getTitle());
                boardBean.setContent(view.getContent());
                boardBean.setUserName(view.getUserName());
                boardBean.setDate(view.getDate());
                break;
            } else {
                boardBean.setTitle("-");
                boardBean.setContent("-");
                boardBean.setUserName("-");
                boardBean.setDate("-");
            }
        }
        return boardBean;
    }

    // 0116 실습 - edit hashMap으로 출력
    public HashMap<String, Object> getDataByUid(String title){
        ArrayList<BoardBean> viewList = getDataListWithBoardBean();
        HashMap<String, Object> hashMap = new HashMap<>();
        for(int i = 0; i < viewList.size(); i++){
            BoardBean view = viewList.get(i);
            if(title.equals(view.getTitle())){
                hashMap.put("title", view.getTitle());
                hashMap.put("content", view.getContent());
                hashMap.put("userName", view.getUserName());
                hashMap.put("date", view.getDate());
                break;
            } else {
                hashMap.put("title", "-");
                hashMap.put("content", "-");
                hashMap.put("userName", "-");
                hashMap.put("date", "-");
            }
        }
        return hashMap;
    }

    // 0116 실습 - view edit한 데이터 출력
    public HashMap<String, Object> getDataByParam(HashMap<String, String> params){
        HashMap<String, Object> viewData = new HashMap<>();
        viewData.put("title", params.get("title"));
        viewData.put("userName", params.get("userName"));
        viewData.put("content",  params.get("content"));
        viewData.put("date", params.get("date"));
        return viewData;
    }
}
