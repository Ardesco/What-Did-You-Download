<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/downloads/css/default.css">
</head>
<body>
<h2>Wicked File Downloads</h2>

<p>This is a wicked file download site that has loads of <strong>amazing</strong> file downloads!</p>

<p>Login to see more!</p>

<form action="j_security_check" method="post">
    <label for="username">Username</label>
    <input id="username" name="j_username" type="text">
    <label for="password">Password</label>
    <input id="password" name="j_password" type="password">
    <input id="login" type="submit" value="Log in">
</form>

<p><a id="terms" class="btn-download" href="real-terms/terms-and-conditions.zip">Terms & Conditions</a></p>

</body>
</html>