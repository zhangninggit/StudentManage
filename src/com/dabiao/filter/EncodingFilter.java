package com.dabiao.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

//        System.out.println("正在经过过滤器filter...");

        // 设置UTF-8编码
        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);

    }

    public void init(javax.servlet.FilterConfig config) throws ServletException {

    }

}
