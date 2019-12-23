<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC表单之-输入框处理</title>
</head>
<body>

    <h2>学生信息</h2>
    <form:form method="POST" action="/dealRegister">
        <table>
              <tr>
                <td><form:label path="id">编号：</form:label></td>
                <td><form:input path="id" />${idError}</td>
            </tr>
            <tr>
                <td><form:label path="name">姓名：</form:label></td>
                <td><form:input path="name" />${nameError}</td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交学生信息" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>