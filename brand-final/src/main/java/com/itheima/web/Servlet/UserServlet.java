package com.itheima.web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
    public void SelectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SelectAll");
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("addServlet");
    }
}
