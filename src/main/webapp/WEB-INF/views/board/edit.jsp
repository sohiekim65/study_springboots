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
    <div class="fs-3 mb-3">Edit Content</div>
    <form action="/board/form" method="post">
      <table class="table">
        <tr>
          <th>Title</th>
          <td>
            <input class="form-control" type="text" name="title" id="" />
          </td>
        </tr>
        <tr>
          <th>Content</th>
          <td>
            <input class="form-control" type="text" name="content" id="" />
          </td>
        </tr>
        <tr>
          <th>UserName</th>
          <td>
            <input class="form-control" type="text" name="userName" id="" />
          </td>
        </tr>
        <tr>
          <th>Date</th>
          <td>
            <input class="form-control" type="text" name="date" id="" />
          </td>
        </tr>
        <tr class="text-center">
          <td colspan="2">
            <button type="submit" class="btn btn-danger">Done</button>
            <a href="/board/view" class="btn btn-secondary">Back</a>
          </td>
        </tr>
      </table>
    </form>
  </div>
  </body>
</html>
