package com.study.study_springboots.utils;

public class Paginations {
    private int pageScale = 10; // 한 페이지 당 게시물(데이터) 개수
    private int currentPage;    // 클릭한 현재 페이지 번호 currentPage는 그때 그때 다름.
    private int totalPage;  // 전체 페이지 개수(75개니까 페이지로는 8페이지(데이터 10개씩이니까))
    private int totalCount; // 전체 리스트(게시물) 개수
    private int pageBegin;  // 페이지 내에서 리스트 시작 번호(123에서 1)
    private int pageEnd;    // 페이지 내에서 리스트 끝나는 번호(123에서 3)

    public Paginations(int totalCount, int currentPage) {
        // 넘어오는 값 : 전체 개수(totalCount), 현재 페이지 개수(currentPage)
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.setTotalPage(totalCount); // totalPage 세팅이 됨
        this.setPageRange();
    }

    // 페이지네이션의 << 123 >> << 456 >> 이렇게 표시하는
    public void setPageRange() {
        pageBegin = (this.currentPage - 1) * this.pageScale + 1;    // 시작점 공식
        pageEnd = this.pageBegin + pageScale - 1;   // 끝나는 번호 공식
    }

    public void setTotalPage(int totalCount) {
        this.totalPage = (int) Math.ceil(totalCount / this.pageScale); 
        // (totalPage = 75 / 10인데 소수점으로 나와서 Math function 사용)
    }

    // getter setter
    public int getPageScale() {
        return pageScale;
    }

    public void setPageScale(int pageScale) {
        this.pageScale = pageScale;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageBegin() {
        return pageBegin;
    }

    public void setPageBegin(int pageBegin) {
        this.pageBegin = pageBegin;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    
}
