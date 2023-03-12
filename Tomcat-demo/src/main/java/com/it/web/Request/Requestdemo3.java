package com.it.web.Request;

import com.it.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/req3")
public class Requestdemo3 extends MyHttpServlet {
    @Override
    protected void doGet(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("req3");
        //读取数据
        Object a=req.getAttribute("msg");
        System.out.println("a");

        //删除数据
        req.removeAttribute("msg");
    }

    @Override
    protected void doPost(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

    }
}
