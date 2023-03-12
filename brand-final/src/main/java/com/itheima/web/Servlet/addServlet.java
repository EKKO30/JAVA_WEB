package com.itheima.web.Servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
    private BrandService brandService=new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接受数据
        BufferedReader a= req.getReader();
        String p=a.readLine();

        //json转java
        Brand brand= JSON.parseObject(p,Brand.class);


//        //获取数据
//        String brandName=req.getParameter("brandName");
//        String companyName=req.getParameter("companyName");
//        String ordered=req.getParameter("ordered");
//        String description=req.getParameter("description");
//        String status=req.getParameter("status");
//
//        //封装对象
//        Brand brand=new Brand();
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setOrdered(Integer.parseInt(ordered));
//        brand.setDescription(description);
//        brand.setStatus(Integer.parseInt(status));

        brandService.add(brand);

        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
