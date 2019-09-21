package com.dabiao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = ((HttpServletRequest) request).getSession();
        Object username = session.getAttribute("username");

        // String contextPath = request.getContextPath();

        String url = request.getRequestURI();

        if(url.contains("login.jsp") || url.contains("js") ||url.contains("/loginServlet")|| url.contains("css")|| url.contains("gif")|| url.contains("jpg")){
            chain.doFilter(request, response);

        }else {
            if (username!=null){
                chain.doFilter(request, response);
            }else {
                request.setAttribute("login_msg","您还未登录，请登录！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }

//        if(username == null || ((String) username).equals("")){
//            System.out.println(url);
//            response.sendRedirect("/login.jsp");
//            chain.doFilter(request,response);
//            return;
//
//        }else{
//            chain.doFilter(request,response);
//            return;
//        }
//        if(!contextPath.equals("/login.jsp")){
//            Object username = request.getSession().getAttribute("username");
//
//            if (username != null){
//                chain.doFilter(request, response);
//            }else {
//                response.sendRedirect(contextPath+"/login.jsp");
//            }
//        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
