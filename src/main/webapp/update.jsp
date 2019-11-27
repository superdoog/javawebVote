<%@ page import="com.lv.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>

</head>
<body>
<%User user = (User) request.getAttribute("user");%>
<form id="update" action="<%=request.getContextPath()%>/updatedo.udo" method="post">
    <table style="margin-left: 100px;padding: 50px;border: 1px #cccccc solid;width: 400px;">
        <input type="hidden" name="id" value="<%=user.getId()%>">
        <%
            String note = (String) request.getAttribute("note");
            if (note != null && !"".equals(note)) {
        %>
        <tr>
            <td style="text-align: right; color: red; font-weight: bold"><%=note%>
            </td>
        </tr>
        <%}%>
        <tr>
            <td style="text-align: right">用户名：</td>
            <td style="text-align: left"><input type="text" name="username" value="<%=user.getUsername()%>"></td>
        </tr>
        <tr>
            <td style="text-align: right">用户密码：</td>
            <td style="text-align: left"><input type="text" name="pasword" value="<%=user.getPasword()%>"></td>
        </tr>
        <tr>
            <td style="text-align: right">投票资格：</td>
            <td style="text-align: left"><input name="qualification" type="radio" value="true"
                <%if(user.getQualification()){%> checked <%}%> >是
            </td>
            <td style="text-align: right"><input name="qualification" type="radio" value="false"
                <%if(!user.getQualification()){%> checked <%}%> >否
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="修改用户"></td>
        </tr>
    </table>
</form>
</body>
</html>
