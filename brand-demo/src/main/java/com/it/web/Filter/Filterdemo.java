package com.it.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

//过滤器用于查看用户是否登录
@WebFilter("/*")
public class Filterdemo implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        //访问资源路径是否与登录有关
        String[] Url={"/login.jsp","/register.jsp","/loginservlet","/RegisterServlet","/css/","/imgs/"};
        String u=req.getRequestURI().toString();

        for (String a: Arrays.asList(Url)
             ) {
            //与登录有关
            if(u.contains(a)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        HttpSession session= req.getSession();
        Object user=session.getAttribute("user");

        //查看是否登录
        if(user!=null){//已登录
            filterChain.doFilter(servletRequest,servletResponse);
        }else {//未登录
            req.setAttribute("login_msg","用户未登录");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
