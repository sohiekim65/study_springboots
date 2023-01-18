<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
    crossorigin="anonymous"
  />
</head>
<body>
    <div>/notice/edit</div>
    <div class="container"> 
    <form action="/notice/view" method="post">
      <div>
        <label for="title">title</label>
        <input type="text " class="form-control" name="title" id="title" value="${hashMap.title}" />
      </div>
      <div>
        <label for="userName">userName</label>
        <input type="text" class="form-control" name="userName" id="userName" value="${hashMap.userName}" />
      </div>
      <div>
        <label for="content">content</label>
        <input type="text" class="form-control" name="content" id="content" value="${hashMap.content}" />
      </div>
      <div>
        <label for="date">date</label>
        <input type="date" class="form-control" name="date" id="date" value="${hashMap.date}" />
      </div>
      <div>
        <button>update</button>
      </div>
       </div>
      <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
</body>
</html>