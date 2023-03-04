package com.itlogin.web;

import com.itlogin.mapper.UserMapper;
import com.itlogin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

//登录
@WebServlet("/loginServlet")
public class Servletdemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取页面资源
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //2.使用mybatis调用sql
        //2.1获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.2创建SqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //2.3获取Mapper对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //2.4使用sql语句
        User user1= mapper.select(username,password);
        //2.5释放资源
        sqlSession.close();

        //3.判断User是否存在
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter=resp.getWriter();
        if(user1!=null){//登录成功
            printWriter.write("登录成功");
        }else {
            printWriter.write("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
