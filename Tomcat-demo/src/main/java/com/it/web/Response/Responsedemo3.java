package com.it.web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/resp3")
public class Responsedemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        resp.setContentType("text/html;charset=utf-8");
        //resp获得字符的输入流
        PrintWriter printWriter= resp.getWriter();
        //可以将响应的数据进行html解析
        resp.setHeader("content-type","text/html");
        printWriter.write("aaaaa");
        printWriter.write("<h1>dasd</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
