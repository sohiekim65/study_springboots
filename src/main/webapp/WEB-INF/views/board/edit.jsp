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
    <div class="fs-3 mb-3">글 수정하기</div>
    <form action="/board/save" method="post">
      <table class="table">
        <tr>
          <th>제목</th>
          <td>
            <input class="form-control" type="text" name="title" id="" />
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <input class="form-control" type="text" name="content" id="" />
          </td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>
            <input class="form-control" type="text" name="userName" id="" />
          </td>
        </tr>
        <tr>
          <th>작성일</th>
          <td>
            <input class="form-control" type="text" name="date" id="" />
          </td>
        </tr>
      </table>
      <div>
        <button type="submit" class="btn btn-danger">완료</button>
      </div>
    </form>
  </div>
  </body>
</html>
