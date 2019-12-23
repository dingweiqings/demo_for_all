<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Spring MVC表单之-输入框处理</title>
</head>
<body>

    <h2>提交的学生信息如下 - </h2>
<table class="easyui-datagrid" style="width:264px;height:620"  
  
        data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">  
  
    <thead>  
  
        <tr>  
  
            <th data-options="field:'itemid',width:66">id</th>  
  
            <th data-options="field:'productid',width:66">Name</th>  
 
        </tr>  
  
   
  
    <c:forEach items="${users}" var="t">   
  
        <tr>  
  
            <th><c:out value="${t.id}" /></th>   
  
            <th><c:out value="${t.name}" /></th>    
  
        </tr>   
  
     </c:forEach>  
  
    </thead>  
  
</table> 
</body>
</html>