# 学生信息管理系统 J2EE版

 使用技术
 - Java: 
    - 基础知识
    
 - 前端:
    - HTML, CSS, JavaScript, Jquery
 
 - J2EE: 
    - Tomcat, Servlet, JSP, Filter
 
 - 数据库:
    - MySQL

## 存在问题

Date()日期转换

```
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-mm-dd");
           Date birthday = null;
           try {
                birthday = simpleDateFormat.parse(request.getParameter("birthday"));
           } catch (ParseException e) {
               e.printStackTrace();
           }
```

Filter解决post请求中文字符乱码

```
public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        System.out.println("正在经过过滤器filter...");

        // 设置UTF-8编码
        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);

    }
```

## 转发forword()与redirct()



## 分页问题解决  2019-8-29 22:51

> 解决思路:  
    
   ![分页](https://i.loli.net/2019/08/30/k1svzRyLaDOpe3h.png)

**PageBean.java**
```
    package com.dabiao.domain;
    
    import java.util.List;
    
    public class PageBean<T> {
    
        private int totalCount; // 总记录数
        private int totalPage ; // 总页码
        private List<T> list ; // 每页的数据
        private int currentPage ; //当前页码
        private int rows;//每页显示的记录数
    
        public int getTotalCount() {
            return totalCount;
        }
    
        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
    
        public int getTotalPage() {
            return totalPage;
        }
    
        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }
    
        public List<T> getList() {
            return list;
        }
    
        public void setList(List<T> list) {
            this.list = list;
        }
    
        public int getCurrentPage() {
            return currentPage;
        }
    
        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }
    
        public int getRows() {
            return rows;
        }
    
        public void setRows(int rows) {
            this.rows = rows;
        }
    }

```


## 获取虚拟路径
> ${pageContext.request.contextPath}  
作用:解决在jsp页面中获取不到url的全路径名问题


## BUG解决之路

1. beta1: 
    > ${pageContext.request.contextPath} jsp页面中的url未添加虚拟路径  ${pageContext.request.contextPath}

2. beta2
    >  在jsp页面中添加虚拟路径时多粘贴了一个 **分号** 
    ```
    <form method="post" action=""${pageContext.request.contextPath}/updateServlet" role="form">
     ```
3. beta3:  Message /listServlet  
    > Type Status Report  
    Message /listServlet  
    Description The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.

4. beta4: sendRedirect  
    > String contextPath = request.getContextPath();
    // 获取项目名 解决部署到服务器中使用重定向操作时无法获取完整路径名 导致的404问题
    ```
    String contextPath = request.getContextPath(); // 获取项目名 解决部署到服务器中使用重定向操作时无法获取完整路径名 导致的404问题
    
            response.sendRedirect(contextPath+"/listServlet");
    ```  
    
    
## Updates: