<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 2019/8/28
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

    <%-- 引入JQ和Bootstrap --%>
        <script src="js/jquery-3.2.1.min.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet">
        <script src="js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet">

    <title>学生管理页面 - 首页</title>


</head>

<body>

<h1 align="center">学生信息</h1>
<div class="listDIV">
    <table class="table table-striped table-bordered table-hover table-condensed">

        <caption>学生列表 - 共${pb.totalCount}人</caption>
        <thead>
        <tr class="success">

            <th>学号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>出生日期</th>

            <th>编辑</th>
            <th>删除</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pb.list}" var="s" varStatus="status">
            <tr>

                <td>${s.student_id}</td>
                <td>${s.name}</td>
                <td>${s.age}</td>
                <td>${s.sex}</td>
                <td>${s.birthday}</td>

                <td><a href="${pageContext.request.contextPath}/editServlet?id=${s.id}"><span class="glyphicon glyphicon-edit"></span> </a></td>
                <td><a href="${pageContext.request.contextPath}/deleteServlet?id=${s.id}"><span class="glyphicon glyphicon-trash"></span> </a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<nav aria-label="Page navigation" class="pageDIV">
    <ul class="pagination">

        <c:if test="${pb.currentPage-1 < 1}">
            <li class="disabled">
                <a href="${pageContext.request.contextPath}/listServlet?currentPage=${pb.currentPage-1}" aria-label="Next">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

        </c:if>

        <c:if test="${pb.currentPage-1 >= 1}">
            <li>
                <a href="${pageContext.request.contextPath}/listServlet?currentPage=${pb.currentPage-1}" aria-label="Next">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

        </c:if>



        <%--<li><a href="#">1</a></li>--%>
       <c:forEach begin="1" end="${pb.totalPage}" var="i">

          <c:if test="${pb.currentPage==i}">
               <li class="active">
                   <a href="${pageContext.request.contextPath}/listServlet?currentPage=${i}">${i}</a>
               </li>
           </c:if>
           <c:if test="${pb.currentPage!=i}">
               <li >
                   <a href="${pageContext.request.contextPath}/listServlet?currentPage=${i}">${i}</a>
               </li>
           </c:if>


       </c:forEach>


        <c:if test="${pb.currentPage+1 > pb.totalPage}">
            <li class="disabled">
                <a href="${pageContext.request.contextPath}/listServlet?currentPage=${pb.currentPage+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>

        </c:if>

        <c:if test="${pb.currentPage+1 <= pb.totalPage}">
            <li>
                <a href="${pageContext.request.contextPath}/listServlet?currentPage=${pb.currentPage+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>

        </c:if>


    </ul>
</nav>



<div class="addDIV">

    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">增加学生</h3>
        </div>
        <div class="panel-body">

            <form method="post" action="${pageContext.request.contextPath}/addServlet" role="form">
                <table class="addTable">
                    <tr>
                        <td>学号：</td>
                        <td><input type="text" name="s_id" id="s_id" placeholder="请在这里输入学号"></td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="name" id="name" placeholder="请在这里输入名字"></td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input type="text" name="age" id="age" placeholder="请在这里输入年龄"></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input type="radio" class="radio radio-inline" name="radio" value="男"> 男
                            <input type="radio" class="radio radio-inline" name="radio" value="女"> 女
                        </td>
                    </tr>
                    <tr>
                        <td>出生日期：</td>
                        <td><input type="date" name="birthday" id="birthday" placeholder="请在这里输入出生日期"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>

                    </tr>

                </table>
            </form>
        </div>
    </div>

</div>

</body>
</html>
