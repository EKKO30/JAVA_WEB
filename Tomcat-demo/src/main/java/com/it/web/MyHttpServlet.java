package com.it.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


//后面的类只需要继承这个类就可以了
@WebServlet("/demo0")
public class MyHttpServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //获得Http请求方式
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        //获得请求方式
        String method=request.getMethod();
        //判断
        if(method.equals("GET")){
            //get处理逻辑
            doGet(servletRequest,servletResponse);
        }else if(method.equals("POST")){
            doPost(servletRequest,servletResponse);
        }
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }


    protected void doGet(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

    }
}
