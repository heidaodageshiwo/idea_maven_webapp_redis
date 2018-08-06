<html>
<body>
<br>
<c:if test="${empty sessionScope.userName}">
    <form onSubmit="doSubmit()" action="login.jsp" method="post">

        <span class="field">账号 ：</span> <input type="text" id="userName" name="userName"> <br>
        <span  class="field">密码(随便填): </span>
        <input type="password" name="password"> <br> <input
            type="submit" value="登录">
    </form>
</c:if>

<c:if test="${!empty sessionScope.userName}">
    <br>
    <table align="centre" border="1">
        <tr>
            <td>Session ID</td>
            <td><%= session.getId() %></td>
        </tr>
        <tr>
            <td>Created on</td>
            <td><%= session.getCreationTime() %></td>
        </tr>
    </table>
    <br>


    当前登陆用户是:<span class="thespan">${sessionScope.userName}</span><br>
    <a href="logout.jsp">点击退出</a>
</c:if>
</body>
</html>
