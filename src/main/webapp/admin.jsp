<%@ page import="java.util.List" %>
<%@ page import="com.lv.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员中心</title>
    <style>
        tr{height: 35px;}
        td{padding: 10px;}
    </style>
</head>
<body>
    <table style="margin-left: 100px;padding: 125px;" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                <form action="<%=request.getContextPath()%>/updateVote.udo" method="post">
                    <input type="submit" value="修改查询信息">
                </form>
            </td>

            <td>
                <form action="<%=request.getContextPath()%>/viewVote.udo" method="post">
                    <input type="submit" value="查看投票情况">
                </form>
            </td>
            <td>
                <form action="<%=request.getContextPath()%>/query.udo" method="post"><input type="submit" value="查询用户"></form>
            </td>
            <td>
                <form action="<%=request.getContextPath()%>/add.jsp" method="post"><input type="submit" value="增加用户"></form>
            </td>
        </tr>
    </table>

    <br>
    <br>



    <table style="margin-left: 100px;padding: 50px;" border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>用户ID</td>
            <td>用户名称</td>
            <td>用户密码</td>
            <td>投票资格</td>
            <td>操作记录</td>
        </tr>

        <%
            List<User> list = (List<User>) request.getAttribute("userList");
            if (list != null && list.size()>0){
            	for (User user:list){
        %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getUsername()%></td>
            <td><%=user.getPasword()%></td>
            <td><%=user.getQualification()%></td>
            <td><a href="<%=request.getContextPath()%>/update.udo?id=<%=user.getId()%>">编辑</a> | <a href="<%=request.getContextPath()%>/delete.udo?id=<%=user.getId()%>">删除</a></td>
        </tr>

        <%
                }
            }
        %>
    </table>
</body>
</html>
