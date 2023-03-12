package com.it.web.Request;

import com.it.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//请求转发
@WebServlet("/req2")
public class Requestdemo2 extends MyHttpServlet {
    @Override
    protected void doGet(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("req2");
        //存储数据
        req.setAttribute("msg","hello");

        //请求转发到demo3
        req.getRequestDispatcher("/req3").forward(req,resp);
    }

    @Override
    protected void doPost(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
