<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Sign in</title>
    <!-- Bootstrap core CSS -->
    <link>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/signin.css" rel="stylesheet">
</head>

<body class="text-center">
<div class="container w-25">
    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">

        <img class="mb-4" src="${pageContext.request.contextPath}/static/img/efrei.svg" alt="" width="144" height="90">

        <h1 class="h3 mb-3 font-weight-normal">Welcome !</h1>
        <h6 class="h6 mb-3 font-weight-normal" style="color: #ff0000">${requestScope.msg}</h6>
        <label class="sr-only"></label>
        <input type="text" name="username" class="form-control" placeholder="Username" required="" autofocus=""/>
        <label class="sr-only">Password</label>
        <input type="password" name="password" class="form-control" placeholder="Password" required=""/>
        <button class="btn btn-lg btn-primary btn-block mt-2" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">© 2019-2020</p>

    </form>
</div>

</body>
</html>
