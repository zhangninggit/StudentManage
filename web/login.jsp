<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 2019/8/30
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="js/jquery-3.2.1.min.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">

    <style>

        body{
           /*# border-style: solid;*/

        }

    </style>

    <title>Title</title>
</head>
<body>

<div class="editDIV">

    <div class="panel panel-success">

        <%--<c:if test="${statue<0}">--%>

            <%--<div class="panel-heading">--%>
                <%--<h3 class="panel-title" style="text-align: center;color: #ac2925">用户名密码或错误！</h3>--%>
            <%--</div>--%>
        <%--</c:if>--%>

        <div class="panel-heading">
            <h3 class="panel-title" style="text-align: center">用户登录</h3>
        </div>
        <div class="panel-body">

            <form method="post" action="${pageContext.request.contextPath}/loginServlet" role="form">
                <table class="editTable">
                    <tr>
                        <td>用户名:</td>
                        <td><input type="text" name="username" id="username"
                                   placeholder="用户名"></td>
                    </tr>

                    <tr>
                        <td>密码:</td>
                        <td><input type="password" name="password" id="password"
                                   placeholder="密码"></td>
                    </tr>

                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">登 录</button>
                        </td>

                    </tr>

                </table>
            </form>

            <!-- 出错显示的信息框 -->
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" >
                    <span>&times;</span>
                </button>
                <strong>${login_msg}</strong>
            </div>

        </div>
    </div>

</div>

    <%--<div style="height:600px;width:600px; margin:auto;border-style: solid; background-image:">--%>

        <%--<form action="" method="post">--%>
            <%--<table class="table">--%>
                <%--<th>管理员登录</th>--%>
                <%--<tr>--%>
                    <%--<td>--%>
                        <%--&lt;%&ndash;<input type="text" id="userName" class="userName" placeholder="用户名">&ndash;%&gt;--%>
                        <%--用户名--%>
                    <%--</td>--%>
                    <%--<td>--%>

                        <%--<input type="text" id="userName" class="userName" placeholder="用户名">--%>
                    <%--</td>--%>
                <%--</tr>--%>

            <%--</table>--%>
        <%--</form>--%>


        <%--&lt;%&ndash;<form class="form-horizontal">--%>
        <%--<div class="form-group">--%>
            <%--<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>--%>
            <%--<div class="col-sm-5">--%>
                <%--<input type="text" class="form-control" id="inputEmail3" placeholder="userName">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for="inputPassword3" class="col-sm-2 control-label">密码</label>--%>
            <%--<div class="col-sm-5">--%>
                <%--<input type="password" class="form-control" id="inputPassword3" placeholder="Password">--%>
            <%--</div>--%>
        <%--</div>--%>


            <%--<div class="form-group">--%>
                <%--<div class="col-sm-offset-2 col-sm-10">--%>
                    <%--<div class="checkbox">--%>
                        <%--<label>--%>
                            <%--<input type="checkbox"> 记住密码--%>
                        <%--</label>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<div class="col-sm-offset-2 col-sm-10">--%>
                    <%--<button type="submit" class="btn btn-default btn-success">登录</button>--%>
                <%--</div>--%>
            <%--</div>--%>

    <%--</form>&ndash;%&gt;--%>

    <%--</div>--%>

</body>
</html>
