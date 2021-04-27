<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="common.jsp"%>
    <title>Title</title>

    <%
        Object username = session.getAttribute("yonghu");
        if(username==null){
            String tishi = "登录用户信息失效，系统将自动退出！";
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('" + tishi + "');");
            writer.write("top.document.location.href='login.jsp'");
            writer.write("</script>");
            writer.close();
        }

    %>


<style>
    html,body{
        width: 100%;
        height: 100%;
        margin: 0px;
        padding: 0px;
    }
    .top{
        width: 100%;
        height: 60px;
        background-color: #1e90ff;
        border-bottom:solid 0px #a9a9a9 ;

    }
    .mid{
        width: 100%;
        height: 40px;
        background-color: #004080;
        border-bottom:solid 0px #a9a9a9 ;

    }
    span{
        color: #ffffff;
    }
</style>

<script type="application/javascript">

  function userManager() {
     //使用jquery操作
      $('#mainframe').attr("src","user/main.jsp")
  }

  function roleManager() {
      //使用jquery操作
      $('#mainframe').attr("src","role/main.jsp")
  }
</script>

</head>
<body >
 <div class="top">
   <table border="0" style="width: 100%;height: 100%">
       <tr>
           <td>
               <img src="imags/login_logo.png">
           </td>
           <td width="20%" align="center">欢迎您：<%= session.getAttribute("yonghu")%></td>
       </tr>
   </table>

 </div>
 <div class="mid">
     &nbsp;&nbsp;&nbsp;
     <a href="#" style="line-height: 40px" onclick="userManager()" >
         <span >用户管理</span>
     </a> &nbsp;&nbsp;&nbsp;  <span >|</span>&nbsp;&nbsp;&nbsp;
     <a href="#">
         <span >部门管理</span>
     </a> &nbsp;&nbsp;&nbsp; <span >|</span>&nbsp;&nbsp;&nbsp;
     <a href="#" onclick="roleManager()">
         <span >角色管理</span>
     </a> &nbsp;&nbsp;&nbsp;  <span >|</span>&nbsp;&nbsp;&nbsp;
     <a href="#">
         <span >菜单管理</span>
     </a>

 </div>

 <div>
    <iframe id="mainframe" style="width: 100%;height: 100%" ></iframe>
 </div>


</body>
</html>
