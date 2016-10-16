<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Login & Register form</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="login-wrap">
    <h2>Error</h2><br>
    <h5>names available: 'name1' 'name2' 'name33_John'</h5>
    <div class="form">
        <input type="text" placeholder="Author Name" id="n" />
        <button onclick="jmp()" id="a1" >Search another Author!</button>
    </div>
</div>
<script src='https://code.jquery.com/jquery-1.10.0.min.js'></script>

<script src="js/index.js"></script>
<script language="javascript">
    function jmp()
    {
        window.location.href="searchauthor.action?name="+document.getElementById("n").value;
    }
</script>
</body>
</html>
