package com.itheima.web.Servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService=new BrandServiceImpl();

    public void SelectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Brand> list= brandService.selectAll();

        //转为json
        String json= JSON.toJSONString(list);

        //响应json到html ajax
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(json);

    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    //批量删除
    public void deleteByIds1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接受数据
        BufferedReader a=req.getReader();
        String p=a.readLine();

        //json转java
        int[] ids=JSON.parseObject(p,int[].class);

        brandService.deleteByIds1(ids);

        resp.getWriter().write("success");

    }

    //分页查询
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //得到当前页数和每页数据
        Integer currentpage=Integer.parseInt(req.getParameter("currentPage"));
        Integer pagesize=Integer.parseInt(req.getParameter("pageSize"));

        PageBean<Brand> pageBean=brandService.selectByPage(currentpage,pagesize);

        //转为json
        String json= JSON.toJSONString(pageBean);

        //响应json到html ajax
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(json);

    }

    //删除一个
    public void deleteone(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接受数据
        BufferedReader a=req.getReader();
        String p=a.readLine();

        //json转java
        int id= JSON.parseObject(p,int.class);

        brandService.deleteone(id);

        resp.getWriter().write("success");

    }

    //动态分页查询
    public void selectByPageAndCondition1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //得到当前页数和每页数据
        Integer currentpage=Integer.parseInt(req.getParameter("currentPage"));
        Integer pagesize=Integer.parseInt(req.getParameter("pageSize"));

        BufferedReader a=req.getReader();
        String p=a.readLine();

        //转为java
        Brand brand=JSON.parseObject(p,Brand.class);

        PageBean<Brand> pageBean= brandService.selectByPageAndCondition1(currentpage,pagesize,brand);

        //转为json
        String q=JSON.toJSONString(pageBean);

        //响应json到html ajax
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(q);

    }
}
