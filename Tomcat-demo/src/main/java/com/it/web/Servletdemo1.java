package com.it.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//访问路径
@WebServlet("/demo1")
public class Servletdemo1 implements Servlet {

    //用于初始化，被访问时调用，只执行一次
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    //访问Servlet自动执行
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行servlet");
    }

    //获取servlet相关信息
    public String getServletInfo() {
        return null;
    }

    //用于回收，只执行一次
    public void destroy() {

    }
}
