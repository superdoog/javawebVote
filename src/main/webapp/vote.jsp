<%@ page import="com.lv.model.Vote" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>投票页面</title>
</head>
<body>
<%Vote vote = (Vote) request.getAttribute("vote");%>
<form action="<%=request.getContextPath()%>/updateVote.udo" method="post">
    <table style="margin-left: 100px;padding: 50px;border: 1px #cccccc solid;width: 400px;">
        <tr>
            <td style="text-align: center">投票信息:</td>
        </tr>
        <tr>
            <td><%=vote.getDetail()%></td>
        </tr>
        <tr>
            <td style="text-align: left"><input name="piao" type="radio" value="true"> 是
            </td>
            <td style="text-align: right"><input name="piao" type="radio" value="false"> 否
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="投票"></td>
        </tr>
    </table>
</form>

</body>
</html>
