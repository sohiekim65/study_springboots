<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </head>

  <body>
    <div class="container mt-3">
      <div class="fs-3 mb-3">게시판</div>
      <table class="table table-hover">
        <thead>
          <tr>
            <th>#</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="board" items="${boardList}" varStatus="status">
            <tr>
              <th>${status.count}</th>
              <td><a href="/board/view?title=${board.title}">${board.title}</a></td>
              <td>${board.userName}</td>
              <td>${board.date}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <div class="">
        <form action="/board/form"><button class="btn btn-danger">글쓰기</button></form></td>
      </div>
    </div>
  </body>
</html>
