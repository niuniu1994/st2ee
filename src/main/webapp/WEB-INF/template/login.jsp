<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Sign in Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link >
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../../static/css/signin.css" rel="stylesheet">
</head>

<body class="text-center">
<form class="form-signin" action="/login" method="post">

    <img class="mb-4" src="../../static/img/efrei.svg" alt="" width="144" height="90">

    <h1 class="h3 mb-3 font-weight-normal" ></h1>
    <h6 class="h6 mb-3 font-weight-normal"  style="color: #ff0000"></h6>
    <label class="sr-only"></label>
    <input type="text" name="username" class="form-control" placeholder="Username" required="" autofocus="">
    <label class="sr-only">Password</label>
    <input type="password" name="password" class="form-control" placeholder="Password" required="">
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button>
    <p class="mt-5 mb-3 text-muted">© 2019-2020</p>

</form>

</body>
</html>
