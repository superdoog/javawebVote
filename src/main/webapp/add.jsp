<%@ page import="com.lv.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>

</head>
<body>
<form action="<%=request.getContextPath()%>/add.udo" method="post">
    <table style="margin-left: 100px;padding: 50px;border: 1px #cccccc solid;width: 400px;">
        <%
            String note = (String) request.getAttribute("note");
            if (note!=null&&!"".equals(note))
            {
        %>
        <tr>
            <td style="text-align: right; color: red; font-weight: bold"><%=note%></td>
        </tr>
        <%}%>
        <tr>
            <td style="text-align: right">用户名：</td>
            <td style="text-align: left"><input type="text" name="username"></td>
        </tr>
        <tr>
            <td style="text-align: right">用户密码：</td>
            <td style="text-align: left"><input type="text" name="pasword"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="注册新用户">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
