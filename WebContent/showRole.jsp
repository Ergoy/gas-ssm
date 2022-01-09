<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <html>
   <head>
     <base href="<%=basePath%>">
     
     <title>ssm</title>
     
     <meta http-equiv="pragma" content="no-cache">
     <meta http-equiv="cache-control" content="no-cache">
     <meta http-equiv="expires" content="0">    
     <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
     <meta http-equiv="description" content="This is my page">
     <!--
     <link rel="stylesheet" type="text/css" href="styles.css">
     -->
 
   </head>
   
   <body>
    <table border="1">
         <tbody>
             <tr>
                 <th>角色编码</th>
                 <th>角色名称</th>
                 <th>创建时间</th>
                 <th>是否管理</th>
             </tr>
             <c:if test="${!empty listRole }">
                 <c:forEach items="${listRole}" var="list">
                     <tr>
                         <td>${list.roleCode }</td>
                         <td>${list.roleName }</td>
                         <td>${list.createDate }</td>
                         <td>${list.isAdminRole }</td>
                     </tr>                
                 </c:forEach>
             </c:if>
         </tbody>
     </table>
   </body>
 </html>