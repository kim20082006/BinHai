<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../common.jsp"%>
    <title>Title</title>
    <style>
    html,body{
        width: 100%;
        height: 100%;
        padding: 0px;
        margin: 0px;
    }
        .top{
            width: 100%;
            height: 40px;
            background-color: #bfbfbf;
        }

    </style>
    <script type="application/javascript" src="main.js"></script>
</head>
<body>
<div class="top" >
   <table border="0" style="width: 100%;height: 100%">
       <tr>
           <td align="center" style="width: 25%">
               <span style="font-size: 22px;color: blue">角色管理</span>
           </td>
           <td align="center" style="width: 25%">角色名称：<input type="text" id="xingming"></td>
           <td align="left" style="width: 25%"> <input type="button" value="查询" onclick="selectUser()"></td>
           <td align="center"> <input type="button" value="添加" onclick="openAdd()"></td>
       </tr>
   </table>

</div>
<div style="width: 100%;height: 100%">
    <table border="1" style="width: 100%;font-size: 14px" id="userList">
        <thead style="background-color: #a2a2a2;font-weight: bold">
        <td align="center" width="60px">序号</td>
        <td align="center">名称</td>
        <td align="center">备注</td>
        <td align="center" width="140px">操作</td>
        </thead>
        <tbody>

        </tbody>
    </table>

</div>


<!--用户信息编辑界面-->
<div id="user" style="display: none;width: 400px;height: 280px;">
    <form method="post">
        <!--隐藏字段，存放id-->
         <input type="hidden" id="id"/>
        <table border="0" style="width: 100%;margin-top: 30px">
            <tr style="height: 40px">
                <td width="70px" align="right">名称:</td>
                <td width="120px"><input type="text" id="name" name="name"/></td>
            </tr>
            <tr style="height: 40px">
                <td align="right">备注:</td>
                <td><textarea id="beizhu"></textarea></td>
            </tr>
            <tr style="height:80px">
                <td colspan="4" align="center">
                    <input type="button" value="提 交" onclick="save()"
                           style="height: 25px;width: 100px;
                           background-color: #004080;color: #ffffff"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>

